package net.masterthought.dlanguage.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.scope.PsiScopeProcessor;
import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
import net.masterthought.dlanguage.resolve.ScopeProcessorImpl;
import net.masterthought.dlanguage.stubs.DLanguageEponymousTemplateDeclarationStub;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public interface DLanguageEponymousTemplateDeclaration extends PsiElement, DNamedElement, StubBasedPsiElement<DLanguageEponymousTemplateDeclarationStub> {
    @Nullable
    public DLanguageIdentifier getIdentifier();

    @Nullable
    public DLanguageTemplateParameters getTemplateParameters();

    @Nullable
    public PsiElement getOP_EQ();

    @Nullable
    public DLanguageType getType();

    @Nullable
    public PsiElement getOP_SCOLON();

    @Nullable
    public PsiElement getKW_ENUM();

    @Nullable
    public PsiElement getKW_ALIAS();

    @Override
    default public boolean processDeclarations(@NotNull PsiScopeProcessor processor,
                                               @NotNull ResolveState state,
                                               PsiElement lastParent,
                                               @NotNull PsiElement place) {
        return ScopeProcessorImpl.INSTANCE.processDeclarations(this, processor, state, lastParent, place);
    }
}
