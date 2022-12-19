package com.example.assignment.ui.coroutines.coroutinepoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.assignment.R
import com.example.assignment.ui.coroutines.coroutinepoc.thread.POCThread
import com.example.networkmodule.continuation.ContinuationPOC
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation

class CRActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cr)
        lifecycleScope.launch {
            ContinuationPOC().renderImage()
        }

    }

}