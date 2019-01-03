package com.example.demo.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        // Map default decorator. This shall be applied to all paths if no other paths match.
        builder.addDecoratorPath("*/com/*", "/WEB-INF/jsp/layout.jsp")
                // Exclude path from decoration.
                .addExcludedPath("*/login")
                .addExcludedPath("*/css/*")
                .addExcludedPath("*/js/*")
                .addExcludedPath("*/vendor/*");
    }

}