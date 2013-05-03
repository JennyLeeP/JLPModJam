package dreamLand.utils.handlers;

import cpw.mods.fml.common.registry.LanguageRegistry;
import dreamLand.utils.Archive;
import dreamLand.utils.LanguageHelper;

public class LanguageHandler {

    public static void loadLanguages() {

        for (String localizationFile : Archive.langFiles){
            LanguageRegistry.instance().loadLocalization(localizationFile,
                    LanguageHelper.getLocaleFromFileName(localizationFile),
                    LanguageHelper.isXMLLanguageFile(localizationFile));
        }
    }
}