package net.masterthought.dlanguage.stubs.types

import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import net.masterthought.dlanguage.psi.DLanguageParameter
import net.masterthought.dlanguage.psi.impl.named.DLanguageParameterImpl
import net.masterthought.dlanguage.stubs.DLanguageParameterStub
import java.io.IOException

/**
 * Created by francis on 6/13/2017.
 */
class DLanguageParameterStubElementType(debugName: String) : DNamedStubElementType<DLanguageParameterStub, DLanguageParameter>(debugName) {

    override fun createPsi(stub: DLanguageParameterStub): DLanguageParameter {
        return DLanguageParameterImpl(stub, this)
    }

    override fun createStub(psi: DLanguageParameter, parentStub: StubElement<*>): DLanguageParameterStub {
        return DLanguageParameterStub(parentStub, this, psi.name, psi.attributes)
    }

    @Throws(IOException::class)
    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): DLanguageParameterStub {
        val namedStubPair = deserializeNamedStub(dataStream, parentStub)
        return DLanguageParameterStub(parentStub, this, namedStubPair.component1(), namedStubPair.component2())

    }
}
