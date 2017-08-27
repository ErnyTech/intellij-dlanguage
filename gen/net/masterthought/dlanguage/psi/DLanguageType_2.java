
    package net.masterthought.dlanguage.psi;

    import com.intellij.psi.PsiElement;
    import org.jetbrains.annotations.NotNull;
    import static net.masterthought.dlanguage.psi.DLanguageTypes.*;
    import org.jetbrains.annotations.Nullable;
    import com.intellij.psi.util.PsiTreeUtil;
    import java.util.List;
    import net.masterthought.dlanguage.psi.interfaces.DNamedElement;
    import net.masterthought.dlanguage.psi.interfaces.DCompositeElement;
    import com.intellij.psi.StubBasedPsiElement;
    import net.masterthought.dlanguage.stubs.interfaces.*;
    import net.masterthought.dlanguage.stubs.*;
    import com.intellij.psi.ResolveState;
    import com.intellij.psi.scope.PsiScopeProcessor;
    import net.masterthought.dlanguage.resolve.ScopeProcessorImpl;




    public interface DLanguageType_2 extends PsiElement {
            @Nullable
            public DLanguageSymbol getSymbol();
            @Nullable
            public DLanguageTypeofExpression getTypeofExpression();
            @Nullable
            public DLanguageTypeConstructor getTypeConstructor();
            @Nullable
            public DLanguageVector getVector();
            @Nullable
            public DLanguageType getType();
            @Nullable
            public DLanguageIdentifierOrTemplateChain getIdentifierOrTemplateChain();
            @Nullable
            public PsiElement getOP_DOT();
        
            @Nullable
            public PsiElement getOP_PAR_RIGHT();
        
            @Nullable
            public PsiElement getOP_PAR_LEFT();
        
            @Nullable
            public DLanguageBuiltinType getBuiltinType();
}