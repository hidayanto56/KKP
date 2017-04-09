SELECT kdsup FROM m04supl



SELECT t03_id, 
tanggal,  
m03.kd_tabung AS kd_tabung, 
m03.jenis_tabung AS jenis_tabung, 
jumlah, 
t03.keterangan 
FROM kkp.t03stok t03
INNER JOIN m03tabu m03
ON m03.kd_tabung = t03.kd_tabung;


INSERT INTO kkp.t03stok (tanggal, 
kd_tabung, 
jumlah, 
keterangan)
VALUES (?,?,?,?,?);

SELECT t03_id, 
tanggal,  
m03.kd_tabung AS kd_tabung, 
m03.jenis_tabung AS jenis_tabung, 
jumlah, 
t03.keterangan 
FROM kkp.t03stok t03
INNER JOIN m03tabu m03
ON m03.kd_tabung = t03.kd_tabung
WHERE tanggal = ? 
AND m03.kd_tabung LIKE ? ;


DELETE FROM t03stok WHERE t03_id= ?;

UPDATE  t03stok SET 
tanggal = ?, 
kd_tabung= ?, 
jumlah = ? 
keterangan = ?
WHERE t03_id = ?;