/*
 * AndroidLauncherAnimation by Stephanus Dai
 * @fullname : Stephanus Bagus Saputra
 *             ( 戴 Dai 偉 Wie 峯 Funk )
 * @email    : wiefunk@stephanusdai.web.id
 * @contact  : http://t.me/wiefunkdai
 * @support  : http://opencollective.com/wiefunkdai
 * @weblink  : http://www.stephanusdai.web.id
 * Copyright (c) ID 2023 Stephanus Bagus Saputra. All rights reserved.
 * Terms of the following https://stephanusdai.web.id/p/license.html
 */

package id.web.stephanusdai.splashanimation

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager

abstract class ScreenLayoutHelper {
    companion object {
        @Suppress("DEPRECATION")
        fun applyToFullscreen(window: Window) {
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
            )
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

            if (Build.VERSION.SDK_INT >= 30) {
                window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            } else {
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LOW_PROFILE or
                            View.SYSTEM_UI_FLAG_FULLSCREEN or
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            }
        }

        @Suppress("DEPRECATION")
        fun applyToNormalscreen(window: Window) {
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
            )

            if (Build.VERSION.SDK_INT >= 30) {
                window.decorView.windowInsetsController?.show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
        
        @SuppressLint("DiscouragedApi")
        public fun getResourceID(context: Context, resName: String): Int {
            try {
                val defPackage = context.applicationContext.packageName
                if (context.resources != null) {
                    return context.resources.getIdentifier(resName, "drawable", defPackage)
                }
            } catch (e: Exception) {
                println(e.printStackTrace())
            }
            return -1
        }

        public fun getDisplayOrientation(context: Context): OrientationType {
            val width: Int = getDisplayWidth(context)
            val height: Int = getDisplayHeight(context)
            return when(width > height) {
                true -> OrientationType.LANDSCAPE
                false -> OrientationType.POTRAIT
            }
        }

        public fun getDisplayOrientation(window: Window): OrientationType {
            val width: Int = getDisplayWidth(window)
            val height: Int = getDisplayHeight(window)
            return when(width > height) {
                true -> OrientationType.LANDSCAPE
                false -> OrientationType.POTRAIT
            }
        }

        public fun getDisplayWidth(context: Context): Int {
            try {
                return context.getResources().getDisplayMetrics().widthPixels
            } catch (e: Exception) {
                return 0
            }
        }

        public fun getDisplayHeight(context: Context): Int {
            try {
                return context.getResources().getDisplayMetrics().heightPixels
            } catch (e: Exception) {
                return 0
            }
        }

        @Suppress("DEPRECATION")
        public fun getDisplayWidth(window: Window): Int {
            try {
                return window.getWindowManager().getDefaultDisplay().getWidth()
            } catch (e: Exception) {
                return 0
            }
        }

        @Suppress("DEPRECATION")
        public fun getDisplayHeight(window: Window): Int {
            try {
                return window.getWindowManager().getDefaultDisplay().getHeight()
            } catch (e: Exception) {
                return 0
            }
        }
    }
}