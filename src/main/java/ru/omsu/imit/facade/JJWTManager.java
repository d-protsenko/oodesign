package ru.omsu.imit.facade;

import info.smart_tools.smartactors.base.exception.invalid_argument_exception.InvalidArgumentException;
import info.smart_tools.smartactors.iobject.ifield_name.IFieldName;
import info.smart_tools.smartactors.iobject.iobject.IObject;
import info.smart_tools.smartactors.iobject.iobject.exception.ReadValueException;
import info.smart_tools.smartactors.ioc.iioccontainer.exception.ResolutionException;
import info.smart_tools.smartactors.iobject.iobject.exception.ChangeValueException;
import info.smart_tools.smartactors.ioc.ikey.IKey;
import info.smart_tools.smartactors.ioc.ioc.IOC;
import info.smart_tools.smartactors.ioc.key_tools.Keys;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * JsonWebToken (JJWT lib) implementation of IJWTManager
 */
public class JJWTManager implements IJWTManager {
    private String issuer;
    private String signingKey;
    private String algorithm;

    /**
     * The constructor
     *
     * @param issuer     tokens issuer
     * @param signingKey signing key for tokens
     * @param algorithm  algorithm for token generation
     */
    public JJWTManager(final String issuer, final String signingKey, final String algorithm) {
        this.issuer = issuer;
        this.signingKey = signingKey;
        this.algorithm = algorithm;
    }

    @Override
    public String generateToken(final int duration, final String subject,
                                final List<String> claimKeys, final IObject claims) throws TokenGenerateException {

        final Duration tokenDuration = Duration.ofMinutes(duration);
        final Instant now = Instant.now();
        try {
            final IKey keyField = Keys.getKeyByName(IFieldName.class.getCanonicalName());

            IFieldName keyFN;
            Claims tokenClaims = Jwts.claims()
                    .setIssuer(issuer)
                    .setIssuedAt(Date.from(now))
                    .setSubject(subject)
                    .setExpiration(Date.from(now.plus(tokenDuration)));
            for (String key : claimKeys) {
                keyFN = IOC.resolve(keyField, key);

                Object toPut = claims.getValue(keyFN);
                if (toPut != null) {
                    tokenClaims.put(key, toPut);
                }
            }
            return Jwts.builder()
                    .setClaims(tokenClaims)
                    .signWith(SignatureAlgorithm.forName(algorithm), signingKey)
                    .compact();
        } catch (ReadValueException ex) {
            throw new TokenGenerateException("Unable to get claims data", ex);
        } catch (SignatureException ex) {
            throw new TokenGenerateException("No such algorithm available", ex);
        } catch (ResolutionException ex) {
            throw new TokenGenerateException("Unable to resolve IFieldName from IOC", ex);
        } catch (InvalidArgumentException | IllegalArgumentException ex) {
            throw new TokenGenerateException("Invalid argument", ex);
        }
    }

    @Override
    public IObject parseTokenToClaimsObject(final String token, final List<String> claimKeys)
            throws TokenExpiredException, TokenMalformedException, TokenParseException {
        try {
            if (token == null || token.isEmpty()) {
                throw new TokenParseException("No token given");
            }

            final IKey keyField = Keys.getKeyByName(IFieldName.class.getCanonicalName());
            final IKey keyIObject = Keys.getKeyByName(IObject.class.getCanonicalName());

            final IObject resultObj = IOC.resolve(keyIObject);

            IFieldName subjectFN = IOC.resolve(keyField, "subject");
            IFieldName claimFN;

            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token);

            resultObj.setValue(subjectFN, claims.getBody().getSubject());
            for (String key : claimKeys) {
                Object value = claims.getBody().get(key);
                if (value != null) {
                    claimFN = IOC.resolve(keyField, key);
                    resultObj.setValue(claimFN, value);
                }
            }
            return resultObj;
        } catch (ExpiredJwtException ex) {
            throw new TokenExpiredException("Token expired", ex);
        } catch (MalformedJwtException | SignatureException ex) {
            throw new TokenMalformedException("Malformed token", ex);
        } catch (ResolutionException ex) {
            throw new TokenParseException("Unable to resolve from IOC", ex);
        } catch (InvalidArgumentException | IllegalArgumentException ex) {
            throw new TokenParseException("Invalid argument", ex);
        } catch (ChangeValueException ex) {
            throw new TokenParseException("Unable to set data", ex);
        }
    }
}
