package vn.mikademy.backend.common.util;

import java.text.Normalizer;

public final class SlugUtils {

    private SlugUtils(){}


    public static String toSlug(String input){
        if(input != null){
            String normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
                    .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            return normalized
                    .toLowerCase()
                    .trim()
                    .replaceAll("[^a-z0-9\\s-]", "")
                    .replaceAll("\\s+", "-")
                    .replaceAll("-+", "-")
                    .replaceAll("^-|-$", "");
            }
        return "";
    }
}
