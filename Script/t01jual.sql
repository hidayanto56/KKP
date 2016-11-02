
SELECT t01_id, tanggal,  
m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, 
m03.harga AS harga, m05.kdcust AS kdcust, 
m05.nmcust AS nmcust, jumlah, t01.keterangan 
FROM kkp.t01jual t01
INNER JOIN m03tabu m03
ON m03.kd_tabung = t01.kd_tabung
INNER JOIN m05cust m05
ON m05.kdcust = t01.kdcust;


SELECT t01_id, tanggal, 
m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, 
m03.harga AS harga, m05.kdcust AS kdcust, 
m05.nmcust AS nmcust, jumlah, t01.keterangan 
FROM kkp.t01jual t01
INNER JOIN m03tabu m03
ON m03.kd_tabung = t01.kd_tabung
INNER JOIN m05cust m05
ON m05.kdcust = t01.kdcust
WHERE tanggal = ? AND m03.kd_tabung LIKE ? AND m05.kdcust LIKE ?;


DELETE FROM t01jual WHERE t01_id = ?;

UPDATE  t01jual SET 
tanggal = ?, 
kd_tabung= ?, 
kdcust= ?, 
jumlah = ? 
keterangan = ?
WHERE t01_id = ?;

INSERT INTO kkp.t01jual (tanggal, kd_tabung, kdcust, jumlah, keterangan)
VALUES (?,?,?,?,?);