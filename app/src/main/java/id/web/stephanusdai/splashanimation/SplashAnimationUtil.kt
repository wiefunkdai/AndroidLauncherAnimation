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

import android.app.PendingIntent.OnFinished
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class SplashAnimationUtil {
    public interface OnFinishAnimationListener {
        fun onFinished()
    }

    public var title: String = "SPLASH ANIMATION"
    public var titleColor: Int =  Color.BLUE
    public var slogan: String = "Utility Launcher Activity"
    public var sloganColor: Int =  Color.DKGRAY
    public var appLogo: String = "@mipmap/ic_launcher"
    public var appLogoResource: Int = 0
    public var authorLabel: String = "Sertifikasi sebagai Profesi Programmer"
    public var authorLabelColor: Int =  Color.GRAY
    public var authorDescription: String = "BNSP Reg. ICT-294-0006250-2017"
    public var authorDescriptionColor: Int =  Color.GRAY
    public var authorLogo: String = "@mipmap/ic_launcher"
    public var authorLogoResource: Int = 0
    public var background: String = "@android:drawable/screen_background_light"
    public var backgroundColor: Int = Color.TRANSPARENT
    public var backgroundResource: Int = 0
    public var copyright: String = "Copyright ID ©2023 Stephanus Bagus Saputra"
    public var copyrightColor: Int =  Color.GRAY
    public var transitionColor: Int =  Color.WHITE
    public val screenWidth: Int get() = getScreenWidth()
    public val screenHeight: Int get() = getScreenHeight()
    public val screenOrientation: OrientationType get() = getScreenOrientation()

    private var onFinishAnimationListener: OnFinishAnimationListener? = null
    private var callbackFinishAnimation: (() -> Unit)? = null

    private lateinit var context: Context
    private lateinit var window: Window

    public constructor(context: Context, window: Window) {
        this.context = context
        this.window = window
        this.registerComponents(context)
    }

    @Suppress("DEPRECATION")
    fun applyToFullscreen() {
        ScreenLayoutHelper.applyToFullscreen(this.window)
    }

    @Suppress("DEPRECATION")
    fun applyToNormalscreen() {
        ScreenLayoutHelper.applyToNormalscreen(this.window)
    }

    @JvmName("title")
    public fun getTitle(): String {
        return this.title
    }

    @JvmName("title")
    public fun setTitle(title: String) {
        this.title = title
    }

    @JvmName("titleColor")
    public fun getTitleColor(): Int {
        return this.titleColor
    }

    @JvmName("titleColor")
    public fun setTitleColor(color: Int) {
        this.titleColor = color
    }

    @JvmName("slogan")
    public fun getSlogan(): String {
        return this.slogan
    }

    @JvmName("slogan")
    public fun setSlogan(slogan: String) {
        this.slogan = slogan
    }

    @JvmName("sloganColor")
    public fun getSloganColor(): Int {
        return this.sloganColor
    }

    @JvmName("sloganColor")
    public fun setSloganColor(color: Int) {
        this.sloganColor = color
    }

    @JvmName("background")
    public fun getBackground(): String {
        return this.background
    }

    @JvmName("background")
    public fun setBackground(resName: String) {
        this.background = resName
        this.setBackgroundResource(ScreenLayoutHelper.getResourceID(this.context, resName))
    }

    @JvmName("backgroundResource")
    fun getBackgroundResource(): Int {
        if (this.backgroundResource == 0) {
            this.setBackgroundResource(ScreenLayoutHelper.getResourceID(this.context, this.background))
        }
        return this.backgroundResource
    }

    @JvmName("backgroundResource")
    public fun setBackgroundResource(resID: Int) {
        this.backgroundResource = resID
    }

    @JvmName("backgroundColor")
    public fun getBackgroundColor(): Int {
        return this.backgroundColor
    }

    @JvmName("backgroundColor")
    public fun setBackgroundColor(color: Int) {
        this.backgroundColor = color
    }

    @JvmName("appLogo")
    public fun getAppLogo(): String {
        return this.appLogo
    }

    @JvmName("appLogo")
    public fun setAppLogo(resName: String) {
        this.appLogo = resName
        this.setAppLogoResource(ScreenLayoutHelper.getResourceID(this.context, resName))
    }

    @JvmName("appLogoResource")
    fun getAppLogoResource(): Int {
        if (this.appLogoResource == 0) {
            this.setAppLogoResource(ScreenLayoutHelper.getResourceID(this.context, this.appLogo))
        }
        return this.appLogoResource
    }

    @JvmName("appLogoResource")
    public fun setAppLogoResource(resID: Int) {
        this.appLogoResource = resID
    }

    @JvmName("authorLogo")
    public fun getAuthorLogo(): String {
        return this.authorLogo
    }

    @JvmName("authorLogo")
    public fun setAuthorLogo(resName: String) {
        this.authorLogo = resName
        this.setAuthorLogoResource(ScreenLayoutHelper.getResourceID(this.context, resName))
    }

    @JvmName("authorLogoResource")
    fun getAuthorLogoResource(): Int {
        if (this.authorLogoResource == 0) {
            this.setAuthorLogoResource(ScreenLayoutHelper.getResourceID(this.context, this.authorLogo))
        }
        return this.authorLogoResource
    }

    @JvmName("authorLogoResource")
    public fun setAuthorLogoResource(resID: Int) {
        this.authorLogoResource = resID
    }

    @JvmName("authorLabel")
    public fun getAuthorLabel(): String {
        return this.authorLabel
    }

    @JvmName("authorLabel")
    public fun setAuthorLabel(label: String) {
        this.authorLabel = label
    }

    @JvmName("authorLabelColor")
    public fun getAuthorLabelColor(): Int {
        return this.authorLabelColor
    }

    @JvmName("authorLabelColor")
    public fun setAuthorLabelColor(color: Int) {
        this.authorLabelColor = color
    }

    @JvmName("authorDescription")
    public fun getAuthorDescription(): String {
        return this.authorDescription
    }

    @JvmName("authorDescription")
    public fun setAuthorDescription(description: String) {
        this.authorDescription = description
    }

    @JvmName("authorDescriptionColor")
    public fun getAuthorDescriptionColor(): Int {
        return this.authorDescriptionColor
    }

    @JvmName("authorDescriptionColor")
    public fun setAuthorDescriptionColor(color: Int) {
        this.authorDescriptionColor = color
    }

    @JvmName("copyright")
    public fun getCopyright(): String {
        return this.copyright
    }

    @JvmName("copyright")
    public fun setCopyright(copyright: String) {
        this.copyright = copyright
    }

    @JvmName("copyrightColor")
    public fun getCopyrightColor(): Int {
        return this.copyrightColor
    }

    @JvmName("copyrightColor")
    public fun setCopyrightColor(color: Int) {
        this.copyrightColor = color
    }

    @JvmName("transitionColor")
    public fun getTransitionColor(): Int {
        return this.transitionColor
    }

    @JvmName("transitionColor")
    public fun setTransitionColor(color: Int) {
        this.transitionColor = color
    }

    @Suppress("DEPRECATION")
    @JvmName("screenWidth")
    public fun getScreenWidth(): Int {
        try {
            return ScreenLayoutHelper.getDisplayWidth(this.window)
        } catch (e: Exception) {
            try {
                return ScreenLayoutHelper.getDisplayWidth(this.context)
            } catch (e: Exception) {
                return 0
            }
        }
    }

    @Suppress("DEPRECATION")
    @JvmName("screenHeight")
    public fun getScreenHeight(): Int {
        try {
            return ScreenLayoutHelper.getDisplayHeight(this.window)
        } catch (e: Exception) {
            try {
                return ScreenLayoutHelper.getDisplayHeight(this.context)
            } catch (e: Exception) {
                return 0
            }
        }
    }

    @Suppress("DEPRECATION")
    @JvmName("screenOrientation")
    public fun getScreenOrientation(): OrientationType {
        try {
            return ScreenLayoutHelper.getDisplayOrientation(this.window)
        } catch (e: Exception) {
            try {
                return ScreenLayoutHelper.getDisplayOrientation(this.context)
            } catch (e: Exception) {
                return OrientationType.POTRAIT
            }
        }
    }

    public fun createContentView(): View {
        return when(screenOrientation) {
            OrientationType.LANDSCAPE -> createViewLandscape()
            OrientationType.POTRAIT -> createViewPortrait()
        }
    }

    public fun setOnFinishAnimationListener(listener: OnFinishAnimationListener) {
        this.onFinishAnimationListener = listener
    }

    public fun setOnFinishAnimation(callback: () -> Unit) {
        this.callbackFinishAnimation = callback
    }

    protected fun onFinishAnimation() {
        this.attachFinishAnimation()
    }

    private fun attachFinishAnimation() {
        if (this.callbackFinishAnimation != null) {
            this.callbackFinishAnimation?.invoke()
        }
        if (this.onFinishAnimationListener != null) {
            this.onFinishAnimationListener?.onFinished()
        }
    }

    private fun createViewPortrait(): View {
        val viewLayout = RelativeLayout(this.context)
        try {
            with(viewLayout) {
                setPadding(50, 50, 50, 50)
                setLayoutParams(RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
                ))
                try {
                    setBackgroundColor(this@SplashAnimationUtil.getBackgroundColor())
                    setBackgroundResource(this@SplashAnimationUtil.getBackgroundResource())
                } catch (e: Exception) {
                    setVisibility(View.INVISIBLE)
                }
            }
            val contentView = LinearLayout(this.context)
            with(contentView) {
                viewLayout.addView(this)
                setOrientation(LinearLayout.VERTICAL)
                setGravity(Gravity.CENTER)
                with(getLayoutParams() as ViewGroup.LayoutParams) {
                    width  = ViewGroup.LayoutParams.WRAP_CONTENT
                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                    gravity = Gravity.CENTER
                }
                with(getLayoutParams() as RelativeLayout.LayoutParams) {
                    addRule(RelativeLayout.CENTER_IN_PARENT)
                }
            }
            val appLogoView = ImageView(this.context)
            with(appLogoView) {
                contentView.addView(this)
                with(getLayoutParams() as ViewGroup.LayoutParams) {
                    width  = (this@SplashAnimationUtil.screenWidth / 2).toInt()
                    height = (this@SplashAnimationUtil.screenWidth / 2).toInt()
                }
                try {
                    setBackgroundColor(Color.TRANSPARENT)
                    setImageResource(this@SplashAnimationUtil.getAppLogoResource())
                } catch (e: Exception) {
                    setVisibility(View.INVISIBLE)
                }
                animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000).withEndAction({
                    val translationTop = (0 - (this@SplashAnimationUtil.screenHeight / 6)).toFloat()
                    contentView.animate().translationY(translationTop).setDuration(500).withEndAction({
                        with(TextView(this@SplashAnimationUtil.context)) {
                            contentView.addView(this)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                            }
                            with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                setMargins(0, -100, 0, 0)
                            }
                            setGravity(Gravity.CENTER_VERTICAL)
                            setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                            setText(this@SplashAnimationUtil.getTitle())
                            setTextColor(this@SplashAnimationUtil.getTitleColor())
                            setTextSize(28f)
                            setTranslationY(-100f)
                            setScaleX(0f)
                            setAlpha(0f)
                            setTypeface(Typeface.DEFAULT_BOLD)
                            animate().scaleX(1f).translationY(0f).alpha(1f).setDuration(500).start()
                        }
                        with(TextView(this@SplashAnimationUtil.context)) {
                            contentView.addView(this)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                            }
                            setGravity(Gravity.CENTER_VERTICAL)
                            setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                            setText(this@SplashAnimationUtil.getSlogan())
                            setTextColor(this@SplashAnimationUtil.getSloganColor())
                            setTextSize(20f)
                            setTranslationY(-100f)
                            setScaleY(0f)
                            setAlpha(0f)
                            setTypeface(Typeface.DEFAULT_BOLD)
                            animate().scaleY(1f).translationY(0f).alpha(1f).setDuration(1000).start()
                        }
                        val authorView = LinearLayout(this.context)
                        with(authorView) {
                            viewLayout.addView(this)
                            setPadding(0, 0, 0, 100)
                            setOrientation(LinearLayout.VERTICAL)
                            setGravity(Gravity.CENTER)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.MATCH_PARENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                                gravity = Gravity.CENTER
                            }
                            with(getLayoutParams() as RelativeLayout.LayoutParams) {
                                addRule(RelativeLayout.CENTER_VERTICAL)
                                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                            }
                            with(ImageView(this@SplashAnimationUtil.context)) {
                                authorView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = 140
                                }
                                try {
                                    setBackgroundColor(Color.TRANSPARENT)
                                    setImageResource(this@SplashAnimationUtil.getAuthorLogoResource())
                                } catch (e: Exception) {
                                    setVisibility(View.INVISIBLE)
                                }
                            }
                            with(TextView(this@SplashAnimationUtil.context)) {
                                authorView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                }
                                with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                    setMargins(0, 32, 0, 0)
                                }
                                setGravity(Gravity.CENTER_VERTICAL)
                                setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                                setText(this@SplashAnimationUtil.getAuthorLabel())
                                setTextColor(this@SplashAnimationUtil.getAuthorLabelColor())
                                setTextSize(14f)
                            }
                            with(TextView(this@SplashAnimationUtil.context)) {
                                authorView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                }
                                setGravity(Gravity.CENTER_VERTICAL)
                                setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                                setText(this@SplashAnimationUtil.getAuthorDescription())
                                setTextColor(this@SplashAnimationUtil.getAuthorDescriptionColor())
                                setTextSize(14f)
                            }
                            with(TextView(this@SplashAnimationUtil.context)) {
                                authorView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                }
                                with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                    setMargins(0, 64, 0, 0)
                                }
                                setGravity(Gravity.CENTER_VERTICAL)
                                setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                                setText(this@SplashAnimationUtil.getCopyright())
                                setTextColor(this@SplashAnimationUtil.getCopyrightColor())
                                setTextSize(14f)
                            }
                            setAlpha(0f)
                            animate().alpha(1f).setDuration(2000).withEndAction({
                                with(RelativeLayout(this.context)) {
                                    viewLayout.addView(this)
                                    try {
                                        setBackgroundColor(this@SplashAnimationUtil.getTransitionColor())
                                    } catch (e: Exception) {
                                        setVisibility(View.INVISIBLE)
                                    }
                                    setLayoutParams(RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.MATCH_PARENT,
                                        RelativeLayout.LayoutParams.MATCH_PARENT
                                    ))
                                    setScaleX(0f)
                                    setScaleY(0f)
                                    setAlpha(0f)
                                    animate().scaleX(1f).scaleY(1f).alpha(0.5f).setDuration(500).withEndAction({
                                        this@SplashAnimationUtil.onFinishAnimation()
                                    }).setStartDelay(2000).start()
                                }
                            }).start()
                        }
                    }).start()
                }).setStartDelay(1000).start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return viewLayout
    }

    private fun createViewLandscape(): View {
        val viewLayout = RelativeLayout(this.context)
        try {

            with(viewLayout) {
                setPadding(50, 50, 50, 50)
                setLayoutParams(RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
                ))
                try {
                    setBackgroundColor(this@SplashAnimationUtil.getBackgroundColor())
                    setBackgroundResource(this@SplashAnimationUtil.getBackgroundResource())
                } catch (e: Exception) {
                    setVisibility(View.INVISIBLE)
                }
            }
            val contentView = LinearLayout(this.context)
            with(contentView) {
                viewLayout.addView(this)
                setOrientation(LinearLayout.HORIZONTAL)
                setGravity(Gravity.CENTER)
                with(getLayoutParams() as ViewGroup.LayoutParams) {
                    width  = ViewGroup.LayoutParams.WRAP_CONTENT
                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                    gravity = Gravity.CENTER
                }
                with(getLayoutParams() as RelativeLayout.LayoutParams) {
                    addRule(RelativeLayout.CENTER_IN_PARENT)
                }
            }
            val appLogoView = ImageView(this.context)
            with(appLogoView) {
                contentView.addView(this)
                with(getLayoutParams() as ViewGroup.LayoutParams) {
                    width = (this@SplashAnimationUtil.screenWidth / 2).toInt()
                    height = (this@SplashAnimationUtil.screenWidth / 2).toInt()
                }
                try {
                    setBackgroundColor(Color.TRANSPARENT)
                    setImageResource(this@SplashAnimationUtil.getAppLogoResource())
                } catch (e: Exception) {
                    setVisibility(View.INVISIBLE)
                }
                animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000).withEndAction({
                    val translationTop = (0 - (this@SplashAnimationUtil.screenHeight / 6)).toFloat()
                    val translationStart = (0 - (this@SplashAnimationUtil.screenWidth / 20)).toFloat()
                    contentView.animate().translationY(translationTop).setDuration(500).start()
                    contentView.animate().translationX(translationStart).setDuration(500).withEndAction({
                        val contentLabelView = LinearLayout(this@SplashAnimationUtil.context)
                        with(contentLabelView) {
                            contentView.addView(this)
                            setOrientation(LinearLayout.VERTICAL)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                            }
                            val marginStart = (0 - (this@SplashAnimationUtil.screenWidth / 10)).toInt()
                            with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                setMargins(marginStart, 0, 0, 0)
                            }
                        }
                        with(TextView(this@SplashAnimationUtil.context)) {
                            contentLabelView.addView(this)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                            }
                            setText(this@SplashAnimationUtil.getTitle())
                            setTextColor(this@SplashAnimationUtil.getTitleColor())
                            setTextSize(28f)
                            setTranslationX(-100f)
                            setScaleX(0f)
                            setAlpha(0f)
                            setTypeface(Typeface.DEFAULT_BOLD)
                            animate().scaleX(1f).translationX(0f).alpha(1f).setDuration(500).start()
                        }
                        with(TextView(this@SplashAnimationUtil.context)) {
                            contentLabelView.addView(this)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                            }
                            setText(this@SplashAnimationUtil.getSlogan())
                            setTextColor(this@SplashAnimationUtil.getSloganColor())
                            setTextSize(20f)
                            setTranslationX(-100f)
                            setScaleX(0f)
                            setAlpha(0f)
                            setTypeface(Typeface.DEFAULT_BOLD)
                            animate().scaleX(1f).translationX(0f).alpha(1f).setDuration(1000).start()
                        }
                        val authorWrapperView = LinearLayout(this.context)
                        with(authorWrapperView) {
                            viewLayout.addView(this)
                            setPadding(0, 0, 0, 100)
                            setOrientation(LinearLayout.VERTICAL)
                            setGravity(Gravity.CENTER)
                            with(getLayoutParams() as ViewGroup.LayoutParams) {
                                width  = ViewGroup.LayoutParams.MATCH_PARENT
                                height = ViewGroup.LayoutParams.WRAP_CONTENT
                                gravity = Gravity.CENTER
                            }
                            with(getLayoutParams() as RelativeLayout.LayoutParams) {
                                addRule(RelativeLayout.CENTER_VERTICAL)
                                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                            }
                            val authorBodyView = LinearLayout(this.context)
                            with(authorBodyView) {
                                authorWrapperView.addView(this)
                                setOrientation(LinearLayout.HORIZONTAL)
                                setGravity(Gravity.CENTER_VERTICAL)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                    gravity = Gravity.CENTER_VERTICAL
                                }
                            }
                            val authorLeftView = LinearLayout(this.context)
                            with(authorLeftView) {
                                authorBodyView.addView(this)
                                setOrientation(LinearLayout.VERTICAL)
                                setGravity(Gravity.CENTER_VERTICAL)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                    gravity = Gravity.CENTER_VERTICAL
                                }
                            }
                            val authorRightView = RelativeLayout(this@SplashAnimationUtil.context)
                            with(authorRightView) {
                                authorBodyView.addView(this)
                                setOrientation(LinearLayout.VERTICAL)
                                setGravity(Gravity.CENTER_VERTICAL)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                    gravity = Gravity.CENTER_VERTICAL
                                }
                            }
                            with(TextView(this@SplashAnimationUtil.context)) {
                                authorLeftView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                }
                                with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                    setMargins(0, 0, 16, 0)
                                }
                                setTextAlignment(TextView.TEXT_ALIGNMENT_VIEW_END)
                                setText(this@SplashAnimationUtil.getAuthorLabel())
                                setTextColor(this@SplashAnimationUtil.getAuthorLabelColor())
                                setTextSize(14f)
                            }
                            with(TextView(this@SplashAnimationUtil.context)) {
                                authorLeftView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                }
                                with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                    setMargins(0, 0, 16, 0)
                                }
                                setTextAlignment(TextView.TEXT_ALIGNMENT_VIEW_END)
                                setText(this@SplashAnimationUtil.getAuthorDescription())
                                setTextColor(this@SplashAnimationUtil.getAuthorDescriptionColor())
                                setTextSize(14f)
                            }

                            with(ImageView(this@SplashAnimationUtil.context)) {
                                authorRightView.addView(this)
                                try {
                                    setBackgroundColor(Color.TRANSPARENT)
                                    setImageResource(this@SplashAnimationUtil.getAuthorLogoResource())
                                } catch (e: Exception) {
                                    setVisibility(View.INVISIBLE)
                                }
                                val maxWidthImage: Int = (this@SplashAnimationUtil.screenWidth / 4).toInt()
                                setMaxWidth(maxWidthImage)
                                setScaleType(ImageView.ScaleType.CENTER_INSIDE)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width = maxWidthImage
                                    height = 140
                                }
                            }
                            with(TextView(this@SplashAnimationUtil.context)) {
                                authorWrapperView.addView(this)
                                with(getLayoutParams() as ViewGroup.LayoutParams) {
                                    width  = ViewGroup.LayoutParams.WRAP_CONTENT
                                    height = ViewGroup.LayoutParams.WRAP_CONTENT
                                }
                                with(getLayoutParams() as ViewGroup.MarginLayoutParams) {
                                    setMargins(0, 32, 0, 0)
                                }
                                setGravity(Gravity.CENTER_VERTICAL)
                                setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER)
                                setText(this@SplashAnimationUtil.getCopyright())
                                setTextColor(this@SplashAnimationUtil.getCopyrightColor())
                                setTextSize(14f)
                            }
                            setAlpha(0f)
                            animate().alpha(1f).setDuration(2000).withEndAction({
                                with(RelativeLayout(this.context)) {
                                    viewLayout.addView(this)
                                    try {
                                        setBackgroundColor(this@SplashAnimationUtil.getTransitionColor())
                                    } catch (e: Exception) {
                                        setVisibility(View.INVISIBLE)
                                    }
                                    setLayoutParams(RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.MATCH_PARENT,
                                        RelativeLayout.LayoutParams.MATCH_PARENT
                                    ))
                                    setScaleX(0f)
                                    setScaleY(0f)
                                    setAlpha(0f)
                                    animate().scaleX(1f).scaleY(1f).alpha(0.5f).setDuration(500).withEndAction({
                                        this@SplashAnimationUtil.onFinishAnimation()
                                    }).setStartDelay(2000).start()
                                }
                            }).start()
                        }
                    }).setStartDelay(500).start()
                }).setStartDelay(1000).start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return viewLayout
    }

    private fun registerComponents(context: Context) {
        try {
            this.setOnFinishAnimationListener(context as OnFinishAnimationListener)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}