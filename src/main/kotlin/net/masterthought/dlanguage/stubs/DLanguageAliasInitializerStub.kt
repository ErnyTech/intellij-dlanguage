package net.masterthought.dlanguage.stubs

import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef
import net.masterthought.dlanguage.attributes.DAttributes
import net.masterthought.dlanguage.psi.DLanguageAliasInitializer
import net.masterthought.dlanguage.types.DType
import net.masterthought.dlanguage.types.ForwardingType

/**
 * Created by francis on 6/13/2017.
 */
class DLanguageAliasInitializerStub : DNamedStubBase<DLanguageAliasInitializer>, ForwardingType {
    override fun getForwardedType(): DType {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    constructor(parent: StubElement<*>?, elementType: IStubElementType<out StubElement<*>, *>?, name: String?, attributes: DAttributes?) : super(parent, elementType, name, attributes)
    constructor(parent: StubElement<*>?, elementType: IStubElementType<out StubElement<*>, *>?, name: StringRef?, attributes: DAttributes?) : super(parent, elementType, name, attributes)
}
