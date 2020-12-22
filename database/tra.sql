-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2020 at 07:14 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tra`
--

-- --------------------------------------------------------

--
-- Table structure for table `approval`
--

CREATE TABLE `approval` (
  `approval_id` int(10) NOT NULL,
  `approval_nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `approval`
--

INSERT INTO `approval` (`approval_id`, `approval_nama`) VALUES
(0, 'decline'),
(1, 'accept'),
(2, 'cancel'),
(3, 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `divisi`
--

CREATE TABLE `divisi` (
  `divisi_id` int(10) NOT NULL,
  `divisi_nama` varchar(50) NOT NULL,
  `divisi_keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `divisi`
--

INSERT INTO `divisi` (`divisi_id`, `divisi_nama`, `divisi_keterangan`) VALUES
(1, 'HR', 'membawahi beberapa karyawan'),
(3, 'ENGINEERING', 'Maintenance perawatan terhadap mesin - mesin produksi'),
(4, 'ACCOUNTING', 'management keuangan perusahaan'),
(8, 'MANAJER', 'Membawahi beberapa karyawan\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `karyawan_id` int(10) NOT NULL,
  `divisi_id` int(10) NOT NULL,
  `karyawan_nama` varchar(50) NOT NULL,
  `karyawan_jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `karyawan_tanggal_lahir` date NOT NULL,
  `karyawan_email` varchar(50) NOT NULL,
  `karyawan_alamat` varchar(50) NOT NULL,
  `karyawan_role` varchar(20) NOT NULL,
  `karyawan_password` varchar(100) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`karyawan_id`, `divisi_id`, `karyawan_nama`, `karyawan_jenis_kelamin`, `karyawan_tanggal_lahir`, `karyawan_email`, `karyawan_alamat`, `karyawan_role`, `karyawan_password`, `active`) VALUES
(4, 1, 'Andi', 'Laki-laki', '1990-12-01', '', 'Yogyakarta', 'ROLE_ADMIN', '$2b$10$EwYfajUBEtGUyGrqtoNWse1FvO9OR2eezGPK1VeVMdltP3TLqplC.', 1),
(7, 3, 'Bambang', 'Laki-laki', '1990-07-31', 'azibrian66@gmail.com', 'Jakarta', 'ROLE_USER', '$2b$10$is9U2n06VpSaHQwpBi7M4eUTo9n8JK0bE5WxNczWFUq6MKDIbNtyS', 1),
(14, 4, 'Ani', 'Perempuan', '1990-09-07', 'jetpistol8989@gmail.com', 'Semarang', 'ROLE_USER', '$2b$10$is9U2n06VpSaHQwpBi7M4eUTo9n8JK0bE5WxNczWFUq6MKDIbNtyS', 1),
(20, 8, 'Burhanudin', 'Laki-laki', '1980-01-07', 'azibrian66@gmail.com', 'Medan', 'ROLE_MANAJER', '$2b$10$SDzaS.lHdwdoPODsNY5YguGlx9IA/O2E2SC3gyscO.lWMWrwMFaAq', 1);

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `kendaraan_id` int(10) NOT NULL,
  `kendaraan_nama` varchar(50) NOT NULL,
  `kendaraan_keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`kendaraan_id`, `kendaraan_nama`, `kendaraan_keterangan`) VALUES
(1, 'Kereta', 'Berangkat menggunakan jalur darat'),
(2, 'Pesawat', 'Menggunakan jalur udara'),
(3, 'Bus', 'Menggunakan jalur darat'),
(7, 'Kapal', 'Berangkat melalui jalur laut'),
(8, 'Mobil', 'Berangkat dengan mobil'),
(9, 'Sepede Motor', 'Berangkat dengan sepeda motor'),
(41, 'Motor', 'keterangan');

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan`
--

CREATE TABLE `pengajuan` (
  `pengajuan_id` int(10) NOT NULL,
  `karyawan_id` int(10) NOT NULL,
  `tujuandinas_id` int(10) NOT NULL,
  `kendaraan_id` int(10) NOT NULL,
  `approval_id` int(10) NOT NULL DEFAULT 3,
  `pengajuan_kota_asal` varchar(50) NOT NULL,
  `pengajuan_kota_tujuan` varchar(50) NOT NULL,
  `pengajuan_waktu_berangkat` varchar(50) NOT NULL,
  `pengajuan_waktu_pulang` varchar(50) NOT NULL,
  `pengajuan_tanggal_berangkat` date NOT NULL,
  `pengajuan_tanggal_pulang` date NOT NULL,
  `pengajuan_hotel` varchar(100) NOT NULL,
  `deleted` varchar(10) NOT NULL DEFAULT '0',
  `pengajuan_komentar` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengajuan`
--

INSERT INTO `pengajuan` (`pengajuan_id`, `karyawan_id`, `tujuandinas_id`, `kendaraan_id`, `approval_id`, `pengajuan_kota_asal`, `pengajuan_kota_tujuan`, `pengajuan_waktu_berangkat`, `pengajuan_waktu_pulang`, `pengajuan_tanggal_berangkat`, `pengajuan_tanggal_pulang`, `pengajuan_hotel`, `deleted`, `pengajuan_komentar`) VALUES
(1, 7, 1, 1, 1, 'Yogyakarta', 'Semarang', '06.00 - 12.00', '18.00 - 00.00', '2020-12-11', '2020-12-16', 'hotel', '0', NULL),
(2, 14, 1, 3, 1, 'Yogyakarta', 'Semarang', '06.00 - 12.00', '18.00 - 00.00', '2020-12-11', '2020-12-13', 'Hotel dengan AC', '0', NULL),
(7, 14, 7, 3, 2, 'Surabaya', 'Depok', '06.00 - 12.00', '18.00 - 24.00', '2020-08-11', '2020-08-13', 'Hotel biasa fasilitas standar', '0', NULL),
(15, 14, 7, 7, 3, 'Manado', 'Semarang', '06.00 - 12.00', '18.00 - 00.00', '2020-10-14', '2020-10-15', 'Hotel biasa', '0', NULL),
(16, 7, 1, 1, 0, 'Yogyakarta', 'Semarang', '00.00 - 06.00', '06.00 - 12.00', '2020-10-15', '2020-10-16', 'Hotel dengan AC dan 1 Tempat tidur', '0', NULL),
(18, 7, 1, 1, 3, 'banten', 'yogykarta', '06.00 - 12.00', '12.00 - 18.00', '2020-10-16', '2020-10-17', 'hotel', '0', NULL),
(19, 7, 1, 9, 2, 'jakarta', 'depok', '06.00 - 12.00', '12.00 - 18.00', '2020-11-08', '2020-11-09', 'hotel', '0', NULL),
(20, 14, 1, 7, 3, 'Samarinda', 'Merauke', '00.00 - 06.00', '18.00 - 00.00', '2020-12-16', '2020-12-18', 'hotel biasa', '0', NULL),
(21, 14, 1, 1, 0, 'Manado', 'Semarang', '00.00 - 06.00', '00.00 - 06.00', '2020-11-08', '2020-11-10', 'Hotel biasa 3', '0', NULL),
(28, 7, 7, 2, 3, 'Madura', 'Palu', '18.00 - 00.00', '00.00 - 06.00', '2020-09-17', '2020-09-19', 'Hotel dengan kapasitas lengkap seperti AC, Air Panas dll', '0', NULL),
(30, 14, 6, 7, 3, 'Surabaya', 'Bengkulu', '06.00 - 12.00', '18.00 - 00.00', '2020-12-19', '2020-12-20', 'hotel dengan air panas', '0', NULL),
(31, 7, 6, 3, 1, 'Balikpapan', 'Padang', '00.00 - 06.00', '18.00 - 00.00', '2020-12-19', '2020-12-21', 'hotel dengan tempat tidur dua', '0', NULL),
(34, 7, 6, 3, 1, 'Yogyakarta', 'Semarang', '06.00 - 12.00', '18.00 - 00.00', '2020-09-20', '2020-09-23', 'Hotel dengan AC', '0', NULL),
(35, 7, 6, 7, 3, 'banten', 'Padang', '06.00 - 12.00', '18.00 - 00.00', '2020-09-20', '2020-09-22', 'hotel', '0', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `perjalanan`
--

CREATE TABLE `perjalanan` (
  `perjalanan_id` int(10) NOT NULL,
  `pengajuan_id` int(10) NOT NULL,
  `perjalanan_karyawan` varchar(100) NOT NULL,
  `perjalanan_tujuan_dinas` varchar(50) NOT NULL,
  `perjalanan_kendaraan` varchar(50) NOT NULL,
  `perjalanan_kota_asal` varchar(50) NOT NULL,
  `perjalanan_kota_tujuan` varchar(50) NOT NULL,
  `perjalanan_waktu_berangkat` time(6) NOT NULL,
  `perjalanan_waktu_pulang` time(6) NOT NULL,
  `perjalanan_tanggal_berangkat` date NOT NULL,
  `perjalanan_tanggal_pulang` date NOT NULL,
  `perjalanan_hotel` varchar(100) DEFAULT NULL,
  `perjalanan_total_diem` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perjalanan`
--

INSERT INTO `perjalanan` (`perjalanan_id`, `pengajuan_id`, `perjalanan_karyawan`, `perjalanan_tujuan_dinas`, `perjalanan_kendaraan`, `perjalanan_kota_asal`, `perjalanan_kota_tujuan`, `perjalanan_waktu_berangkat`, `perjalanan_waktu_pulang`, `perjalanan_tanggal_berangkat`, `perjalanan_tanggal_pulang`, `perjalanan_hotel`, `perjalanan_total_diem`) VALUES
(1, 2, 'Ani', 'Kunjungan', 'Bus', 'Yogyakarta', 'Semarang', '08:30:08.000000', '21:44:18.000000', '2020-12-11', '2020-12-13', 'Hotel dengan AC', 700000),
(3, 2, 'Ani', 'Kunjungan', 'Bus', 'Yogyakarta', 'Semarang', '00:49:00.000000', '12:46:00.000000', '2020-12-10', '2020-12-12', 'Hotel dengan AC', 700000),
(13, 34, 'Bambang', 'Deployment', 'Bus', 'Yogyakarta', 'Semarang', '02:17:00.000000', '15:18:00.000000', '2020-12-19', '2020-12-21', 'Hotel dengan AC', 1500000);

-- --------------------------------------------------------

--
-- Table structure for table `tujuandinas`
--

CREATE TABLE `tujuandinas` (
  `tujuandinas_id` int(10) NOT NULL,
  `tujuandinas_nama` varchar(50) NOT NULL,
  `tujuandinas_diem` int(20) NOT NULL,
  `tujuandinas_keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tujuandinas`
--

INSERT INTO `tujuandinas` (`tujuandinas_id`, `tujuandinas_nama`, `tujuandinas_diem`, `tujuandinas_keterangan`) VALUES
(1, 'Kunjungan', 350000, 'melakukan kunjungan rutin'),
(6, 'Deployment', 750000, 'Deployment yang dibutuhkan'),
(7, 'Maintenance', 250000, 'Maintenance project secara rutin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `approval`
--
ALTER TABLE `approval`
  ADD PRIMARY KEY (`approval_id`);

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`divisi_id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`karyawan_id`),
  ADD KEY `devisi_id1` (`divisi_id`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`kendaraan_id`);

--
-- Indexes for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD PRIMARY KEY (`pengajuan_id`),
  ADD KEY `karyawan_id1` (`karyawan_id`),
  ADD KEY `tujuandinas_id1` (`tujuandinas_id`),
  ADD KEY `kendaraan_id1` (`kendaraan_id`),
  ADD KEY `approval_id1` (`approval_id`);

--
-- Indexes for table `perjalanan`
--
ALTER TABLE `perjalanan`
  ADD PRIMARY KEY (`perjalanan_id`),
  ADD KEY `pengajuan_id1` (`pengajuan_id`);

--
-- Indexes for table `tujuandinas`
--
ALTER TABLE `tujuandinas`
  ADD PRIMARY KEY (`tujuandinas_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `divisi`
--
ALTER TABLE `divisi`
  MODIFY `divisi_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `karyawan_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `kendaraan_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `pengajuan`
--
ALTER TABLE `pengajuan`
  MODIFY `pengajuan_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `perjalanan`
--
ALTER TABLE `perjalanan`
  MODIFY `perjalanan_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tujuandinas`
--
ALTER TABLE `tujuandinas`
  MODIFY `tujuandinas_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `devisi_id1` FOREIGN KEY (`divisi_id`) REFERENCES `divisi` (`divisi_id`);

--
-- Constraints for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD CONSTRAINT `approval_id1` FOREIGN KEY (`approval_id`) REFERENCES `approval` (`approval_id`),
  ADD CONSTRAINT `karyawan_id1` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`karyawan_id`),
  ADD CONSTRAINT `kendaraan_id1` FOREIGN KEY (`kendaraan_id`) REFERENCES `kendaraan` (`kendaraan_id`),
  ADD CONSTRAINT `tujuandinas_id1` FOREIGN KEY (`tujuandinas_id`) REFERENCES `tujuandinas` (`tujuandinas_id`);

--
-- Constraints for table `perjalanan`
--
ALTER TABLE `perjalanan`
  ADD CONSTRAINT `pengajuan_id1` FOREIGN KEY (`pengajuan_id`) REFERENCES `pengajuan` (`pengajuan_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
