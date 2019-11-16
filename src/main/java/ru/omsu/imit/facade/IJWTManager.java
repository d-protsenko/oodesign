package ru.omsu.imit.facade;
import info.smart_tools.smartactors.iobject.iobject.IObject;

import java.util.List;

/**
 * Interface that describes facade for jwt manager
 */
public interface IJWTManager {

    /**
     * Function contract to generate token
     *
     * @param duration   token duration
     * @param subject    subject for token
     * @param claimKeys  list of claim keys
     * @param claims     object with claim fields
     * @return generated token (String)
     * @throws TokenGenerateException if unable to generate token
     */
    String generateToken(int duration, String subject,
                         List<String> claimKeys, IObject claims) throws TokenGenerateException;


    /**
     * Function contract to parse token string
     *
     * @param token      token string
     * @param claimKeys  list of claim keys
     * @return object from parsed token with claims & subject
     * @throws TokenExpiredException   if given token already expired
     * @throws TokenMalformedException if given token has the wrong sign
     * @throws TokenParseException     if unable to parse token
     */
    IObject parseTokenToClaimsObject(String token, List<String> claimKeys) throws
            TokenExpiredException, TokenMalformedException, TokenParseException;
}
