package doituong;

public class DichVu {

	private int id;
	
	private String tenDichVu;
	
	private String giaDichVu;
	
	private String moTa;
	
	private String trangThai;

	public DichVu() { }
	
	public DichVu(int id, String tenDichVu, String giaDichVu, String moTa, String trangThai) {
		this.id = id;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
		this.moTa = moTa;
		this.trangThai = trangThai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

        public String getGiaDichVu() {
            return giaDichVu;
        }

        public void setGiaDichVu(String giaDichVu) {
            this.giaDichVu = giaDichVu;
        }

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
