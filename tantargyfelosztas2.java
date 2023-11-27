public class tantargyfelosztas2 {
    public class Tanfel {

        public Tanfel(String tanarNev, String tantargy, String osztaly, int hetiOra) {
            this.setTanarNev(tanarNev);
            this.setTantargy(tantargy);
            this.setOsztaly(osztaly);
            this.setHetiOra(hetiOra);
        }
    
        public String getTanarNev() {
            return tanarNev;
        }
    
        public void setTanarNev(String tanarNev) {
            this.tanarNev = tanarNev;
        }
    
        public String getTantargy() {
            return tantargy;
        }
    
        public void setTantargy(String tantargy) {
            this.tantargy = tantargy;
        }
    
        public String getOsztaly() {
            return osztaly;
        }
    
        public void setOsztaly(String osztaly) {
            this.osztaly = osztaly;
        }
    
        public int getHetiOra() {
            return hetiOra;
        }
    
        public void setHetiOra(int hetiOra) {
            this.hetiOra = hetiOra;
        }
    
        @Override
        public String toString() {
            return "Tanár :" + tanarNev + ", Tantárgy: " + tantargy + ", Osztály: " + osztaly + ", Hetióra: " + hetiOra ;
        }
    
        private String tanarNev, tantargy, osztaly;
        private int hetiOra;
    }
}
