package de.gaalop.gealg.output;

import de.gaalop.CodeGenerator;
import de.gaalop.CodeGeneratorPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * This class implements the Plugin interface for Gaalop.
 */
public class Plugin implements CodeGeneratorPlugin {

    private Log log = LogFactory.getLog(Plugin.class);

    private Image icon;

    public Plugin() {
        URL url = getClass().getResource("icon.png");
        if (url != null) {
            try {
                icon = ImageIO.read(url);
            } catch (IOException e) {
                log.error("Unable to read plugin icon " + url);
            }
        } else {
            log.warn("Unable to find plugin icon!");
        }
    }

    @Override
    public CodeGenerator createCodeGenerator() {
        return CppCodeGenerator.INSTANCE;
    }

    @Override
    public String getName() {
        return "C/C++ (gealg)";
    }

    @Override
    public String getDescription() {
        return "This plugin generates C/C++ code putting the output data in a gealg mulivector.";
    }

    @Override
    public Image getIcon() {
        return icon;
    }
}
