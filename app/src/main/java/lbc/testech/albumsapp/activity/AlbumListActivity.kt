package lbc.testech.albumsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import lbc.testech.albumsapp.R
import lbc.testech.albumsapp.fragment.AlbumsListFragment
import lbc.testech.albumsapp.utils.AlbumsListFragmentTag
import lbc.testech.albumsapp.viewmodel.AlbumViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumListActivity : AppCompatActivity() {

    private val albumViewModel: AlbumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)
        switchToFragment(AlbumsListFragment.newInstance(), AlbumsListFragmentTag, false)
        albumViewModel.id.observe(this, Observer {
        })
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
