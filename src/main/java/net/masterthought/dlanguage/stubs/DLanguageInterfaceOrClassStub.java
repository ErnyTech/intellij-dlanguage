package net.masterthought.dlanguage.stubs;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import net.masterthought.dlanguage.attributes.DAttributes;
import net.masterthought.dlanguage.psi.DLanguageInterfaceOrClass;
import net.masterthought.dlanguage.stubs.interfaces.HasMembersStub;

public class DLanguageInterfaceOrClassStub extends DNamedStubBase<DLanguageInterfaceOrClass> implements HasMembersStub {
    private final boolean isInterface;

    public DLanguageInterfaceOrClassStub(final StubElement parent, final IStubElementType elementType, final String name, final DAttributes attributes, boolean isInterface) {
        super(parent, elementType, name, attributes);
        this.isInterface = isInterface;
    }

    public DLanguageInterfaceOrClassStub(final StubElement parent, final IStubElementType elementType, final StringRef name, final DAttributes attributes, boolean isInterface) {
        super(parent, elementType, name, attributes);
        this.isInterface = isInterface;
    }

    public boolean isInterface() {
        return isInterface;
    }
}
