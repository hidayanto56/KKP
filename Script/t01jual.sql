
SELECT t01_id, tanggal, t01.m03_id, 
m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, 
m03.harga AS harga, t01.m05_id, m05.kdcust AS kdcust, 
m05.nmcust AS nmcust, jumlah, t01.keterangan 
FROM kkp.t01jual t01
INNER JOIN m03tabu m03
ON m03.m03_id = t01.m03_id
INNER JOIN m05cust m05
ON m05.m05_id = t01.m05_id;
