/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.net.InetAddress;
import java.net.PasswordAuthentication;

/**
 *
 * @author bartj_000
 */
public abstract class Authenticator {

    private InetAddress requestingSite;
    private int requestingPort;
    private String requestingProtocol;
    private String requestingPrompt;
    private String requestingUserName;

    public Authenticator() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: invokespecial java/lang/Object."<init>":()V
         * 4: return
         *  */
        // </editor-fold>
    }

    private void reset() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: aconst_null
         * 2: putfield      javax/mail/Authenticator.requestingSite:Ljava/net/InetAddress;
         * 5: aload_0
         * 6: iconst_m1
         * 7: putfield      javax/mail/Authenticator.requestingPort:I
         * 10: aload_0
         * 11: aconst_null
         * 12: putfield      javax/mail/Authenticator.requestingProtocol:Ljava/lang/String;
         * 15: aload_0
         * 16: aconst_null
         * 17: putfield      javax/mail/Authenticator.requestingPrompt:Ljava/lang/String;
         * 20: aload_0
         * 21: aconst_null
         * 22: putfield      javax/mail/Authenticator.requestingUserName:Ljava/lang/String;
         * 25: return
         *  */
        // </editor-fold>
    }

    final PasswordAuthentication requestPasswordAuthentication(InetAddress addr, int port, String protocol, String prompt, String defaultUserName) {
        return null;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: invokespecial javax/mail/Authenticator.reset:()V
         * 4: aload_0
         * 5: aload_1
         * 6: putfield      javax/mail/Authenticator.requestingSite:Ljava/net/InetAddress;
         * 9: aload_0
         * 10: iload_2
         * 11: putfield      javax/mail/Authenticator.requestingPort:I
         * 14: aload_0
         * 15: aload_3
         * 16: putfield      javax/mail/Authenticator.requestingProtocol:Ljava/lang/String;
         * 19: aload_0
         * 20: aload         4
         * 22: putfield      javax/mail/Authenticator.requestingPrompt:Ljava/lang/String;
         * 25: aload_0
         * 26: aload         5
         * 28: putfield      javax/mail/Authenticator.requestingUserName:Ljava/lang/String;
         * 31: aload_0
         * 32: invokevirtual javax/mail/Authenticator.getPasswordAuthentication:()Ljavax/mail/PasswordAuthentication;
         * 35: areturn
         *  */
        // </editor-fold>
    }

    protected final InetAddress getRequestingSite() {
        return null;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      javax/mail/Authenticator.requestingSite:Ljava/net/InetAddress;
         * 4: areturn
         *  */
        // </editor-fold>
    }

    protected final int getRequestingPort() {
        return 0;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      javax/mail/Authenticator.requestingPort:I
         * 4: ireturn
         *  */
        // </editor-fold>
    }

    protected final String getRequestingProtocol() {
        return null;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      javax/mail/Authenticator.requestingProtocol:Ljava/lang/String;
         * 4: areturn
         *  */
        // </editor-fold>
    }

    protected final String getRequestingPrompt() {
        return null;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      javax/mail/Authenticator.requestingPrompt:Ljava/lang/String;
         * 4: areturn
         *  */
        // </editor-fold>
    }

    protected final String getDefaultUserName() {
        return null;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: getfield      javax/mail/Authenticator.requestingUserName:Ljava/lang/String;
         * 4: areturn
         *  */
        // </editor-fold>
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aconst_null
         * 1: areturn
         *  */
        // </editor-fold>
    }
}
