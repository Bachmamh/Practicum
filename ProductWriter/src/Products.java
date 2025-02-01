public class Products {
        String ID;
        String Name;
        String Description;
        double Cost;


        public Products(String ID, String Name, String Description, Double Cost)
        {
            this.ID = ID;
            this.Name = Name;
            this.Description = Description;
            this.Cost = Cost;


        }

        public String toString()
        {
            return ID + ", " + Name + ", " + Description + ", " + Cost;
        }
    }

