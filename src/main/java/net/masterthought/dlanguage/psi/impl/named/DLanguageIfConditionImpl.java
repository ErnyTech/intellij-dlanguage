package net.masterthought.dlanguage.psi.impl.named;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import net.masterthought.dlanguage.psi.DLanguageExpression;
import net.masterthought.dlanguage.psi.DLanguageIdentifier;
import net.masterthought.dlanguage.psi.DLanguageIfCondition;
import net.masterthought.dlanguage.psi.DLanguageType;
import net.masterthought.dlanguage.psi.impl.DNamedStubbedPsiElementBase;
import net.masterthought.dlanguage.stubs.DLanguageIfConditionStub;
import net.masterthought.dlanguage.types.DType;
import net.masterthought.dlanguage.types.TypeUtilsKt;
import org.apache.commons.lang.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.masterthought.dlanguage.psi.DLanguageTypes.KW_AUTO;
import static net.masterthought.dlanguage.psi.DLanguageTypes.OP_EQ;

/**
 * Created by francis on 7/14/2017.
 */
public class DLanguageIfConditionImpl extends DNamedStubbedPsiElementBase<DLanguageIfConditionStub> implements DLanguageIfCondition {
    public DLanguageIfConditionImpl(@NotNull final DLanguageIfConditionStub stub, final IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public DLanguageIfConditionImpl(final ASTNode node) {
        super(node);
    }

    @Nullable
    @Override
    public DLanguageIdentifier getNameIdentifier() {
        return getIdentifier();
    }

    @Nullable
    @Override
    public DLanguageIdentifier getIdentifier() {
        return PsiTreeUtil.getChildOfType(this, DLanguageIdentifier.class);
    }

    @Nullable
    @Override
    public DLanguageExpression getExpression() {
        return PsiTreeUtil.getChildOfType(this, DLanguageExpression.class);
    }

    @Nullable
    @Override
    public PsiElement getKW_AUTO() {
        return findChildByType(KW_AUTO);
    }

    @Nullable
    @Override
    public DLanguageType getType() {
        return PsiTreeUtil.getChildOfType(this, DLanguageType.class);
    }

    @Nullable
    @Override
    public PsiElement getOP_EQ() {
        return findChildByType(OP_EQ);
    }

    @Override
    @NotNull
    public DType getTypeOf() {
        if (getGreenStub() != null) {
            return getGreenStub().getTypeOf();
        }
        if (getKW_AUTO() != null) {
            throw new NotImplementedException();
        }
        return TypeUtilsKt.from(getType(), true);
    }
}
