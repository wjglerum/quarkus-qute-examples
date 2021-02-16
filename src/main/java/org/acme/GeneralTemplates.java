package org.acme;


import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;

@CheckedTemplate
public class GeneralTemplates {
    public static native TemplateInstance error(String message);
}
