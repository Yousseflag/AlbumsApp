package lbc.testech.albumsapp.activity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.fragment.AlbumsListFragment
import lbc.testech.albumsapp.fragment.PhotoDialogFragment
import lbc.testech.albumsapp.fragment.PhotosListFragment
import lbc.testech.albumsapp.utils.AlbumsListFragmentTag
import lbc.testech.albumsapp.utils.PhotosListFragmentTag
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumListActivity : AppCompatActivity() {

    private val albumViewModel: AlbumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)
        switchToFragment(AlbumsListFragment.newInstance(), AlbumsListFragmentTag, false)
        initObservers()
    }

    private fun initObservers() {
        albumViewModel.id.observe(this, Observer { albumId ->
            switchToFragment(PhotosListFragment.newInstance(albumId), PhotosListFragmentTag, true)
        })
        albumViewModel.url.observe(this, Observer { url ->
            showPhotoDialog(url)
        })
    }

    private fun showPhotoDialog(photoUrl: String) {
        val transaction = supportFragmentManager.beginTransaction()
        val previous = supportFragmentManager.findFragmentByTag("tag")
        if (previous != null) {
            transaction.remove(previous)
        }
        transaction.addToBackStack(null)

        val dialogFragment = PhotoDialogFragment.newInstance(photoUrl)
        dialogFragment.show(transaction, "tag")
    }
    private fun switchToFragment(fragment: Fragment, tag: String, addToBackStack: Boolean) {
        val transactionFragment = supportFragmentManager.beginTransaction()
            .replace(
                R.id.act_photo_details_container, fragment,
                tag
            )
        if (addToBackStack) { transactionFragment.addToBackStack(tag) }

        transactionFragment.commit()
    }
}
