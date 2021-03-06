package com.example.xmlselector_example

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val cancelButton: TextView = view.findViewById(R.id.cancelButton)
        val confirmButton: TextView = view.findViewById(R.id.confirmButton)

        cancelButton.isPressed = true

        cancelButton.setOnTouchListener { _, _ ->
            cancelButton.isPressed = true
            confirmButton.isPressed = false
            true
        }

        confirmButton.setOnTouchListener { _, _ ->
            confirmButton.isPressed = true
            cancelButton.isPressed = false
            true
        }

        val backButton: TextView = view.findViewById(R.id.backButton)
        backButton.setOnClickListener {
            Log.d("Back", "Stop the Program")
        }

        val okButton: TextView = view.findViewById(R.id.okButton)
        okButton.setOnClickListener {
            activity?.let {
                Log.d("Next Page", "Go to Detail Page from Main Page")
                findNavController().navigate(R.id.action_mainFragment_to_detailPage)
            }
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}