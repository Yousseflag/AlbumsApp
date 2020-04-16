package lbc.testech.albumsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import kotlinx.android.synthetic.main.dialog_fragment_photo.*
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.utils.FRAGMENT_ARG_PHOTO_URL
import lbc.testech.albumsapp.utils.GlideApp
import lbc.testech.albumsapp.utils.USER_AGENT

class PhotoDialogFragment : DialogFragment() {

    private var photoUrl: String? = null

    companion object {
        fun newInstance(photoUrl: String): PhotoDialogFragment =
            PhotoDialogFragment().apply {
                val bundle = Bundle()
                bundle.putString(FRAGMENT_ARG_PHOTO_URL, photoUrl)
                arguments = bundle
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_photo, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photoUrl = it.getString(FRAGMENT_ARG_PHOTO_URL)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = GlideUrl(
            photoUrl, LazyHeaders.Builder()
                .addHeader("User-Agent", USER_AGENT)
                .build()
        )
        GlideApp.with(this).asBitmap().load(url).into(image)
    }
}