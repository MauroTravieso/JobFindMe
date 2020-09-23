package com.example.jobfindme.activity

import android.icu.number.NumberFormatter.with
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobfindme.R
import com.example.jobfindme.model.User
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso


class HomeActivity : AppCompatActivity()   {

     lateinit var mSearchText : EditText
     lateinit var mRecyclerView : RecyclerView
       lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        mSearchText = findViewById(R.id.searchText)
        mRecyclerView = findViewById(R.id.list_view)


        mDatabase = FirebaseDatabase.getInstance().getReference("Users")


        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))

        mSearchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val searchText = mSearchText.getText().toString().trim()

                //loadFirebaseData(searchText)
            }
        })

//        private fun loadFirebaseData(searchText : String) {
//
//            if(searchText.isEmpty()){
//
//                FirebaseRecyclerAdapter.cleanup()
//                mRecyclerView.adapter = FirebaseRecyclerAdapter()
//
//            }else {
//
//
//                val firebaseSearchQuery = mDatabase.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff")
//
//                FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<User, UsersViewHolder>(
//
//                    User::class.java,
//                    R.layout.layout_list,
//                    UsersViewHolder::class.java,
//                    firebaseSearchQuery
//
//
//                ) {
//                    override fun populateViewHolder(viewHolder: UsersViewHolder, model: User?, position: Int) {
//
//
//                        viewHolder.mview.userName.setText(model?.name)
//                        viewHolder.mview.userStatus.setText(model?.status)
//                        Picasso.with(applicationContext).load(model?.image).into(viewHolder.mview.UserImageView)
//
//                    }
//
//                }
//
//                mRecyclerView.adapter = FirebaseRecyclerAdapter
//
//            }
//        }


    }
}