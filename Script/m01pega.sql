SELECT nik, nama,

INSERT INTO m01pega (
nik, 
nama, 
username,
PASSWORD, 
gender, 
STATUS, 
telepon, 
alamat, 
agama, 
tgllahir, 
email, 
tglmasuk, 
kdjab)
VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);


UPDATE m01pega SET 
nama=?, 
username=?,
PASSWORD=?, 
gender=?, 
STATUS=?, 
telepon=?, 
alamat=?, 
agama=?, 
tgllahir=?, 
email=?, 
tglmasuk=?, 
kdjab = ?
WHERE nik = ?; 
