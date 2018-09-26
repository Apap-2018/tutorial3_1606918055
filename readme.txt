1. Hasilnya adalah page berhasil menambahkan dan tidak error
2. Hasilnya adalah page error bad request, karena semua parameter required namun kita tidak memberikan
   semua parameter yang dibutuhkan yaitu, amount
3. Ya muncul
4. Tidak, karena kita tidak me-record data secara persistent di db sehingga ketika server direstart
   data akan kembali kosong.
5. Ya muncul di dalam list.
6. Ya semua data car muncul, dengan asumsi data yang dimasukan setelah server start terakhir.
gt