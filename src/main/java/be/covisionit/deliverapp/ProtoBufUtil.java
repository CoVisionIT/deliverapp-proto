package be.covisionit.deliverapp;

import be.covisionit.deliverapp.proto.DespatchAdvice;

import java.nio.charset.Charset;

public final class ProtoBufUtil {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static String toQrString(DespatchAdvice despatchAdvice) {
        return new String(despatchAdvice.toByteArray(), ISO_8859_1);
    }

}
