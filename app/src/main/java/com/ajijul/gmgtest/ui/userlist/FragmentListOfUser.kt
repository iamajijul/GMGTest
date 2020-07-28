package com.ajijul.gmgtest.ui.userlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajijul.gmgtest.R
import com.ajijul.gmgtest.base.BaseFragment
import com.ajijul.gmgtest.network.ResponseWrapper
import com.ajijul.gmgtest.ui.adapters.UsersAdapter
import fr.dasilvacampos.network.monitoring.Event
import fr.dasilvacampos.network.monitoring.NetworkConnectivityListener
import kotlinx.android.synthetic.main.fragment_list_of_user.*


class FragmentListOfUser : BaseFragment(R.layout.fragment_list_of_user),
    NetworkConnectivityListener {

    lateinit var userAdapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOurRecyclerView()
    }


    private fun observerOfflineData() {
        viewModel.observeUsersOffline().observe(viewLifecycleOwner, Observer {
            it?.let {
                userAdapter.submitList(it)
            }
        })
    }

    private fun observerNetworkData() {
        handleProgress(true)
        viewModel.observeUsersOnline().observe(viewLifecycleOwner, Observer {

                    handleProgress(false)
                    it?.let {
                        userAdapter.submitList(it)
                    }

        })
    }

    private fun setUpOurRecyclerView() {
        userAdapter = UsersAdapter()
        userAdapter.setOnClickListener {
            viewModel.setSelectedUser(it)
            findNavController().navigate(R.id.action_fragmentListOfArticles_to_fragmentUserDetails)

        }
        rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun handleProgress(isShow: Boolean) {
        if (isShow) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    override fun networkConnectivityChanged(event: Event) {
        when (event) {
            is Event.ConnectivityEvent -> if (event.isConnected) {
                observerNetworkData()
            } else {
                messageHandlerImp.showSnackErrorWithAction(
                    mainView,
                    R.string.ok,
                    R.string.offlineMesssage
                ) {
                }
                observerOfflineData()
            }
        }
    }
}