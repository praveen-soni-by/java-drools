package com.syscho.drool.helper;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;

public class DroolHelper {

    public static KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        setFilesPath(kieFileSystem);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        //Optional
        KieModule kieModule = kieBuilder.getKieModule();

        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    private static void setFilesPath(KieFileSystem kieFileSystem) {
        kieFileSystem.write(ResourceFactory.newClassPathResource("Voting.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("Aadhar.drl"));
    }
}
