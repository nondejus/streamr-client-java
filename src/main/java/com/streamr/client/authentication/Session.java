package com.streamr.client.authentication;

/**
 * Holds credentials for getting new sessionTokens, and holds the current sessionToken.
 * Currently only supports the API key. Support for Ethereum-based authentication needs to
 * be added later.
 */
public class Session {

    private final AuthenticationMethod authenticationMethod;
    private final String restApiUrl;
    private String sessionToken = null;

    public Session(String restApiUrl, AuthenticationMethod authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
        this.restApiUrl = restApiUrl;
    }

    public boolean isAuthenticated() {
        return authenticationMethod != null;
    }

    public String getSessionToken() {
        if (sessionToken == null && isAuthenticated()) {
            sessionToken = authenticationMethod.newSessionToken(restApiUrl);
        }
        return sessionToken;
    }

    public String getNewSessionToken() {
        sessionToken = null;
        return getSessionToken();
    }
}
