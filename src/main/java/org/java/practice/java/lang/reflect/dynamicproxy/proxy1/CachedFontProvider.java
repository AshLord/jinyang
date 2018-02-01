package org.java.practice.java.lang.reflect.dynamicproxy.proxy1;

import java.util.Map;

public class CachedFontProvider implements FontProvider{

    private FontProvider fontProvider;

    private Map<String, Font> cached;

    public CachedFontProvider(FontProvider fontProvider) {
        this.fontProvider = fontProvider;
    }

    @Override
    public Font getFont(String name) {
        Font font = cached.get(name);
        if (font == null) {
            font = fontProvider.getFont(name);
            cached.put(name, font);
        }
        return font;
    }
}
