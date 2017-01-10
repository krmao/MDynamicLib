package com.mlibrary.multiapk

import com.mlibrary.multiapk.util.TextUtil
import org.gradle.api.Project;

public class LibraryExtension {
    //notNull
    public String packageName;
    public String moduleProguardRulesFilePath;

    //nullAble
    public String libsDirPath;
    public String sourceDirPath;
    public String assetsDirPath;
    public String resourceDirPath;
    public String androidManifestFilePath;

    public String parentModuleName;
    public String soName;

    @Override
    public String toString() {
        return "    LibraryExtension{" +
                "\n        ****[must not be null]****" +
                "\n        packageName='" + packageName + '\'' +
                "\n        moduleProguardRulesFilePath='" + moduleProguardRulesFilePath + '\'' +
                "\n" +
                "\n        ****[can    be   null]****" +
                "\n        libsDirPath='" + libsDirPath + '\'' +
                "\n        sourceDirPath='" + sourceDirPath + '\'' +
                "\n        assetsDirPath='" + assetsDirPath + '\'' +
                "\n        resourceDirPath='" + resourceDirPath + '\'' +
                "\n        androidManifestFilePath='" + androidManifestFilePath + '\'' +
                "\n        parentModuleName='" + parentModuleName + '\'' +
                "\n        soName='" + soName + '\'' +
                '\n    }';
    }

    public
    static void initLibraryExtensionAfterEvaluate(LibraryExtension libraryExtension, Project libraryProject) {
        libraryExtension.libsDirPath = TextUtil.isEmpty(libraryExtension.libsDirPath) ? "$libraryProject.projectDir/libs" : libraryExtension.libsDirPath
        libraryExtension.sourceDirPath = TextUtil.isEmpty(libraryExtension.sourceDirPath) ? "$libraryProject.projectDir/src/main/java" : libraryExtension.sourceDirPath
        libraryExtension.resourceDirPath = TextUtil.isEmpty(libraryExtension.resourceDirPath) ? "$libraryProject.projectDir/src/main/res" : libraryExtension.resourceDirPath
        libraryExtension.assetsDirPath = TextUtil.isEmpty(libraryExtension.assetsDirPath) ? "$libraryProject.projectDir/src/main/assets" : libraryExtension.assetsDirPath
        libraryExtension.androidManifestFilePath = TextUtil.isEmpty(libraryExtension.androidManifestFilePath) ? "$libraryProject.projectDir/src/main/AndroidManifest.xml" : libraryExtension.androidManifestFilePath
        libraryExtension.soName = libraryExtension.packageName.replace('.', '_')

        println("$libraryProject.path:apply multiApkLibrary:initLibraryExtensionAfterEvaluate:\n" + libraryExtension.toString())
    }
}