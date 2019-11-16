package ru.omsu.imit.facade;

import info.smart_tools.smartactors.feature_loading_system.bootstrap.Bootstrap;
import info.smart_tools.smartactors.field_plugins.ifield_plugin.IFieldPlugin;
import info.smart_tools.smartactors.iobject.ds_object.DSObject;
import info.smart_tools.smartactors.iobject.ifield_name.IFieldName;
import info.smart_tools.smartactors.iobject.iobject.IObject;
import info.smart_tools.smartactors.iobject_plugins.dsobject_plugin.PluginDSObject;
import info.smart_tools.smartactors.iobject_plugins.ifieldname_plugin.IFieldNamePlugin;
import info.smart_tools.smartactors.ioc.ikey.IKey;
import info.smart_tools.smartactors.ioc.ioc.IOC;
import info.smart_tools.smartactors.ioc.key_tools.Keys;
import info.smart_tools.smartactors.ioc_plugins.ioc_keys_plugin.PluginIOCKeys;
import info.smart_tools.smartactors.ioc_plugins.ioc_simple_container_plugin.PluginIOCSimpleContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FacadeTest {

    private IJWTManager manager;
    private String issuer = "issuer";
    private String signingKey = "liuqeqw324zxcpovzkrq381zlhgeqe7";
    private String subject = "subject";
    private List<String> keys = new ArrayList<>();
    private IObject claims;

    @Before
    public void init() throws Exception {
        claims = new DSObject("{\"email\":\"test\"}");
        keys.add("email");
            Bootstrap bootstrap = new Bootstrap();
            new PluginIOCSimpleContainer(bootstrap).load();
            new PluginIOCKeys(bootstrap).load();
            new IFieldNamePlugin(bootstrap).load();
            new IFieldPlugin(bootstrap).load();
            new PluginDSObject(bootstrap).load();
            bootstrap.start();
        manager = new JJWTManager(issuer, signingKey, "HS512");
    }

    @Test
    public void testGenerateToken() throws Exception {
        assertNotNull(manager.generateToken(100, subject, keys, claims));
    }

    @Test(expected = TokenGenerateException.class)
    public void testGenerateTokenException() throws Exception {
        manager = new JJWTManager(issuer, "", "HS512");
        manager.generateToken(100, subject, keys, new DSObject("{}"));
    }

    @Test
    public void testParseToken() throws Exception {
        manager = new JJWTManager(issuer, signingKey, "HS512");
        String token = manager.generateToken(100, subject, keys, claims);
        IKey fnKey = Keys.getKeyByName(IFieldName.class.getCanonicalName());
        IFieldName subjectFN = IOC.resolve(fnKey, "subject");
        IFieldName emailFN = IOC.resolve(fnKey, "email");
        IObject parsed = manager.parseTokenToClaimsObject(
                token,
                keys
        );
        assertEquals(subject, parsed.getValue(subjectFN));
        assertEquals("test", parsed.getValue(emailFN));
    }

    @Test(expected = TokenExpiredException.class)
    public void testParseTokenExpired() throws Exception {
        String token = manager.generateToken(0, subject, keys, claims);
        manager.parseTokenToClaimsObject(
                token,
                keys
        );
    }

    @Test(expected = TokenMalformedException.class)
    public void testParseTokenMalformed() throws Exception {
        String token = manager.generateToken(100, subject, keys, claims);
        manager = new JJWTManager(issuer, signingKey + "s", "HS512");
        manager.parseTokenToClaimsObject(
                token,
                keys
        );
    }

    @Test(expected = TokenParseException.class)
    public void testParseTokenException() throws Exception {
        manager = new JJWTManager(issuer, signingKey, "HS512");
        String token = manager.generateToken(100, subject, keys, claims);
        manager = new JJWTManager(issuer, "", "HS512");
        manager.parseTokenToClaimsObject(
                token,
                keys
        );
    }
}


