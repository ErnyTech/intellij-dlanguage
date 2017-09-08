package net.masterthought.dlanguage.jps.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsElementChildRole;
import org.jetbrains.jps.model.JpsProject;
import org.jetbrains.jps.model.ex.JpsCompositeElementBase;
import org.jetbrains.jps.model.ex.JpsElementChildRoleBase;

public class JpsDLanguageBuildOptionsExtension extends JpsCompositeElementBase<JpsDLanguageBuildOptionsExtension> {
    public static final JpsElementChildRole<JpsDLanguageBuildOptionsExtension> ROLE = JpsElementChildRoleBase.create("DLanguageBuildOptions");

    private DLanguageBuildOptions myOptions;

    public JpsDLanguageBuildOptionsExtension(final DLanguageBuildOptions options) {
        myOptions = options;
    }

    @NotNull
    public static JpsDLanguageBuildOptionsExtension getOrCreateExtension(@NotNull final JpsProject project) {
        JpsDLanguageBuildOptionsExtension extension = project.getContainer().getChild(ROLE);
        if (extension == null) {
            extension = project.getContainer().setChild(ROLE, new JpsDLanguageBuildOptionsExtension(new DLanguageBuildOptions()));
        }
        return extension;
    }

    @NotNull
    @Override
    public JpsDLanguageBuildOptionsExtension createCopy() {
        return new JpsDLanguageBuildOptionsExtension(new DLanguageBuildOptions(myOptions));
    }

    public DLanguageBuildOptions getOptions() {
        return myOptions;
    }

    public void setOptions(final DLanguageBuildOptions options) {
        myOptions = options;
    }

    @Override
    public String toString() {
        return "JpsDLanguageBuildOptionsExtension{" +
            "myOptions=" + myOptions +
            '}';
    }
}
