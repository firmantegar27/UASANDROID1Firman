package com.example.uasandroidfirman

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RemoteViews.RemoteCollectionItems
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uasandroidfirman.databinding.ActivityMainBinding
import com.example.uasandroidfirman.db.NoteRoomDatabase
import com.example.uasandroidfirman.model.Note
import com.example.uasandroidfirman.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Cek apakah data sudah dimasukkan sebelumnya
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val isDataInserted = sharedPreferences.getBoolean("isDataInserted", false)

        if (!isDataInserted) {
            // Jika belum dimasukkan, maka masukkan data dan simpan status ke shared preferences
            addDummyData()
            sharedPreferences.edit().putBoolean("isDataInserted", true).apply()
        }

        // Menampilkan data dari database ke dalam RecyclerView
        getNotesDate()

        binding.floatingAdd.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun addDummyData() {
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()

        // Membuat 50 data dan memasukkannya ke dalam database
        // Data dummy
        val dummyDataList = listOf(
            Note(
                title = "2169700028",
                nama = "Firman Tegar",
                nilai = "4.00",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20.000"
            ),
            Note(
                title = "2169700012",
                nama = "Ratu Nurul Fauziah",
                nilai = "4.00",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20.000"
            ),
            Note(
                title = "2169700018",
                nama = "Meli Ai Hayati Rahmah",
                nilai = "4.00",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20.000"
            ),
            Note(
                title = "2169700024",
                nama = "Harys Hakim Kurniawan",
                nilai = "4.00",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20.000"
            ),
            Note(
                title = "2169700022",
                nama = "Toibul Khoiri",
                nilai = "4.00",
                keterangan = "Lulus",
                jumlahsks = "21",
                hargasks = "20.000"
            ),
            Note(
                title = "2169700044",
                nama = "Dwiki Wisnu Aji",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700042",
                nama = "Wita Dwiyanti",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700041",
                nama = "Ilham Rizky Ramadhan",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700039",
                nama = "Ersa Putra Riano",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700038",
                nama = "Kosmara",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700037",
                nama = "Siti Muslihah",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700036",
                nama = "Lina Faujiah",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700035",
                nama = "Yusuf Ardiansyah",
                nilai = "1.80",
                keterangan = "Tidak Lulus",
                jumlahsks = "7",
                hargasks = "50.000"
            ),
            Note(
                title = "2169700030",
                nama = "Lulu Fauziyah",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700029",
                nama = "Chandra Yulistianto",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700008",
                nama = "Lukman Muhamad Syamil",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700013",
                nama = "Anna Silvana",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700014",
                nama = "Adi Suharyadi",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700015",
                nama = "Dani Ramadon",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700019",
                nama = "Duta Rizky Darmawan",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700020",
                nama = "Wahyu Hidayat",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700021",
                nama = "Riska Yulinar",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700025",
                nama = "Gilang Pramudya Asega",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700027",
                nama = "Tapan Nurzaman Malik",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700001",
                nama = "Salsa Dwiyanti",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700004",
                nama = "Yeni Nuraeni",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700005",
                nama = "Tiara Agustin",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700006",
                nama = "Listiani Lesveva Setiawan",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2169700007",
                nama = "Sendi Rahman Huda",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
            Note(
                title = "2069700002",
                nama = "Tomi Riki Saputra",
                nilai = "",
                keterangan = "",
                jumlahsks = "",
                hargasks = ""
            ),
        )

        // Menambahkan data ke dalam database
        for (dummyNote in dummyDataList) {
            dao.insert(dummyNote)
        }
    }


    private fun getNotesDate() {
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()
        val listItems = arrayListOf<Note>()
        listItems.addAll(dao.getAll())
        setupRecyclerView(listItems)
    }

    private fun setupRecyclerView(listItems: ArrayList<Note>) {
        binding.recycleViewMain.apply {
            adapter = NoteAdapter(listItems, object : NoteAdapter.NoteListener {
                override fun OnItemClicked(note: Note) {
                    val intent = Intent(this@RoomActivity, EditActivity::class.java)
                    intent.putExtra(EditActivity().EDIT_NOTE_EXTRA, note)
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(this@RoomActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getNotesDate()
    }
}

