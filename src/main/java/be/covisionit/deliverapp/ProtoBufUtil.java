package be.covisionit.deliverapp;

import be.covisionit.deliverapp.proto.DespatchAdvice;

import java.nio.charset.StandardCharsets;

public final class ProtoBufUtil {

    public static String toQrString(DespatchAdvice despatchAdvice) {
        return new String(despatchAdvice.toByteArray(), StandardCharsets.ISO_8859_1);
    }

}
