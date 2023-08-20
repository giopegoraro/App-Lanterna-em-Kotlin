package com.giord.primeiroapp

import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giord.primeiroapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var estado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.lanterna.setOnClickListener {
            if (!estado) {
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_ligada)
                estado = true
                luzDaLanterna(estado)
            }else{
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_desligada)
                estado = false
                luzDaLanterna(estado)
            }
        }
    }

    private fun luzDaLanterna(estado:Boolean){
        val cameraManager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        val cameraId: String?

        try {
            cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId,estado)
        }catch (e: Exception){

        }
    }
}