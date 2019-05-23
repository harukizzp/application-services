/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.appservices.httpconfig

import android.util.Log
import com.sun.jna.Library
import com.sun.jna.Callback
import com.sun.jna.Native
import java.lang.reflect.Proxy
import mozilla.appservices.support.RustBuffer
import mozilla.appservices.support.loadIndirect
import org.mozilla.appservices.httpconfig.BuildConfig

@Suppress("FunctionNaming", "TooGenericExceptionThrown")
internal interface LibViaduct : Library {
    companion object {
        internal var INSTANCE: LibViaduct = {
            val inst = loadIndirect<LibViaduct>(libName = "viaduct", libVersion = BuildConfig.LIBRARY_VERSION)
            inst.viaduct_force_enable_ffi_backend(1)
            inst
        }()
    }

    fun viaduct_destroy_bytebuffer(b: RustBuffer.ByValue)
    // Returns null buffer to indicate failure
    fun viaduct_alloc_bytebuffer(sz: Int): RustBuffer.ByValue
    // Returns 0 to indicate redundant init.
    fun viaduct_initialize(cb: RawFetchCallback): Byte

    fun viaduct_force_enable_ffi_backend(b: Byte)
}

internal interface RawFetchCallback : Callback {
    fun invoke(b: RustBuffer.ByValue): RustBuffer.ByValue
}
