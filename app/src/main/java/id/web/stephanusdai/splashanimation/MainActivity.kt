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

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import id.web.stephanusdai.splashanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SplashAnimationUtil.OnFinishAnimationListener {
    private lateinit var splashAnimationUtil: SplashAnimationUtil
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashAnimationUtil = SplashAnimationUtil(this, window)
        with(splashAnimationUtil) {
            applyToFullscreen()
            setTitleColor(Color.parseColor("#4D88C6"))
            setAuthorLogo("@drawable/ic_stephanusdai_logo")
            this@MainActivity.setContentView(createContentView())
        }
    }

    override fun onFinished() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        splashAnimationUtil.applyToNormalscreen()
        this.setContentView(binding.root)
        with(binding.mainLayout) {
            setScaleX(0f)
            setScaleY(0f)
            setAlpha(0f)
            animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(500).start()
        }
    }
}