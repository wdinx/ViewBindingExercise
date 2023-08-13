package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.example.barvolume.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    private lateinit var edtLength: EditText
//    private lateinit var edtWidth: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView

    private lateinit var binding: ActivityMainBinding

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        edtLength = findViewById(R.id.edtLength)
//        edtWidth = findViewById(R.id.edtWidth)
//        btnCalculate = findViewById(R.id.btnCalculate)
//        tvResult = findViewById(R.id.tvResult)

        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnCalculate){
            val inputLength = binding.edtLength.text.toString().trim()
            val inputWidth = binding.edtWidth.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()){
                isEmptyFields = true
                binding.edtLength.error = "Field tidak boleh kosong"
            }

            if (inputWidth.isEmpty()){
                isEmptyFields = true
                binding.edtLength.error = "Field tidak boleh kosong"
            }

            if(!isEmptyFields){
                val calculate = inputLength.toDouble() * inputWidth.toDouble()

                binding.tvResult.text = calculate.toString()
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

}