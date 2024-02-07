package com.example.uasandroidfirman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.uasandroidfirman.databinding.ActivityEditBinding
import com.example.uasandroidfirman.db.NoteDao
import com.example.uasandroidfirman.db.NoteRoomDatabase
import com.example.uasandroidfirman.model.Note

@Suppress("DEPRECATION")
class EditActivity : AppCompatActivity() {

    val EDIT_NOTE_EXTRA = "edit_note_extra"
    private  lateinit var note: Note
    private var isUpdate = false
    private lateinit var database: NoteRoomDatabase
    private lateinit var dao: NoteDao


    private lateinit var binding: ActivityEditBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        database = NoteRoomDatabase.getDatabase(applicationContext)
        dao = database.getNoteDao()


        if (intent.getParcelableExtra<Note>(EDIT_NOTE_EXTRA) != null) {
            binding.buttonDelete.visibility = View.VISIBLE
            isUpdate = true
            note = intent.getParcelableExtra(EDIT_NOTE_EXTRA)!!

            binding.editTextTitle.setText(note.title)
            binding.editTextName.setText(note.nama)
            binding.editTextScore.setText(note.nilai)
            binding.editTextKet.setText(note.keterangan)
            binding.editTextJumsks.setText(note.jumlahsks)
            binding.editTextHargasks.setText(note.hargasks)

            binding.editTextTitle.setSelection(note.title.length)
        }
        binding.buttonSave.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val nama = binding.editTextName.text.toString()
            val nilai = binding.editTextScore.text.toString()
            val keterangan = binding.editTextKet.text.toString()
            val jumlahsks = binding.editTextJumsks.text.toString()
            val hargasks = binding.editTextHargasks.text.toString()

            binding.editTextTitle.setText(title)
            binding.editTextName.setText(nama)
            binding.editTextScore.setText(nilai)
            binding.editTextKet.setText(keterangan)
            binding.editTextJumsks.setText(jumlahsks)
            binding.editTextHargasks.setText(hargasks)

            if (title.isEmpty() && nama.isEmpty() && nilai.isEmpty() && keterangan.isEmpty() && jumlahsks.isEmpty() && hargasks.isEmpty()){
                Toast.makeText(applicationContext, "Note cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                if (isUpdate){
                    saveNote(Note(id = note.id, title = title, nama = nama, nilai=nilai, keterangan=keterangan, jumlahsks=jumlahsks, hargasks=hargasks))
                }
                else{
                    saveNote(Note(title = title, nama = nama, nilai=nilai, keterangan=keterangan, jumlahsks=jumlahsks, hargasks=hargasks))
                }
            }
            finish()
        }

        binding.buttonDelete.setOnClickListener {
            deleteNote(note)
            finish()
        }
    }

    private fun saveNote(note: Note){

        if (isUpdate) {
            dao.update(note)
        } else {
            dao.insert(note)
        }

        Toast.makeText(applicationContext, "Note saved", Toast.LENGTH_SHORT).show()
    }

    private fun deleteNote(note: Note){
        dao.delete(note)
        Toast.makeText(applicationContext, "Note remove", Toast.LENGTH_SHORT).show()
    }
}