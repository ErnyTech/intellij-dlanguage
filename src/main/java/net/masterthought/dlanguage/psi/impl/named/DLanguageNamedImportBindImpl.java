package net.masterthought.dlanguage.psi.impl.named;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.DLanguageIdentifier;
import net.masterthought.dlanguage.psi.DLanguageNamedImportBind;
import net.masterthought.dlanguage.psi.DLanguageVisitor;
import net.masterthought.dlanguage.psi.impl.DNamedStubbedPsiElementBase;
import net.masterthought.dlanguage.stubs.DLanguageNamedImportBindStub;
import net.masterthought.dlanguage.types.DType;
import org.apache.commons.lang.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.masterthought.dlanguage.psi.DLanguageTypes.OP_EQ;


public class DLanguageNamedImportBindImpl extends DNamedStubbedPsiElementBase<DLanguageNamedImportBindStub> implements DLanguageNamedImportBind {

    public DLanguageNamedImportBindImpl(final DLanguageNamedImportBindStub stub, final IStubElementType type) {
        super(stub, type);
    }

    public DLanguageNamedImportBindImpl(final ASTNode node) {
        super(node);
    }

    public void accept(@NotNull final DLanguageVisitor visitor) {
        visitor.visitNamedImportBind(this);
    }

    public void accept(@NotNull final PsiElementVisitor visitor) {
        if (visitor instanceof DLanguageVisitor) accept((DLanguageVisitor) visitor);
        else super.accept(visitor);
    }

    @Nullable
    @Override
    public PsiElement getOP_EQ() {
        return findChildByType(OP_EQ);
    }

    @Override
    @Nullable
    public DLanguageIdentifier getIdentifier() {
        return PsiTreeUtil.getStubChildOfType(this, DLanguageIdentifier.class);
    }

    @Nullable
    @Override
    public DLanguageIdentifier getNameIdentifier() {
        return getIdentifier();
    }

    @Override
    public DType getForwardedType() {
        if (getGreenStub() != null) {
            return getGreenStub().getForwardedType();
        }
        throw new NotImplementedException();
    }
}
