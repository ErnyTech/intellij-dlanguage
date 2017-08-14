package net.masterthought.dlanguage.stubs.types

import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import net.masterthought.dlanguage.psi.DLanguageCatch
import net.masterthought.dlanguage.psi.impl.named.DLanguageCatchImpl
import net.masterthought.dlanguage.stubs.DLanguageCatchStub
import java.io.IOException

/**
 * Created by francis on 6/13/2017.
 */

class CatchStubElementType(debugName: String) : DNamedStubElementType<DLanguageCatchStub, DLanguageCatch>(debugName) {
    override fun createPsi(stub: DLanguageCatchStub): DLanguageCatch {
        return DLanguageCatchImpl(stub, this)
    }

    override fun shouldCreateStub(node: ASTNode?): Boolean {
        return true
    }

    override fun createStub(psi: DLanguageCatch, parentStub: StubElement<*>): DLanguageCatchStub {
        return DLanguageCatchStub(parentStub, this, psi.name, psi.attributes)
    }

    @Throws(IOException::class)
    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): DLanguageCatchStub {
        val namedStubPair = deserializeNamedStub(dataStream, parentStub)
        return DLanguageCatchStub(parentStub, this, namedStubPair.component1(), namedStubPair.component2())

    }

}
