package org.example;

import java.util.*;

interface discount {
    void buyticket();

    void applydiscount();
}

abstract class Animal {
    private int id;
    private String name;
    private String type;
    private String sound;
    private String description;

    public Animal(int id, String name, String type, String sound, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sound = sound;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Mammals extends Animal {
    public Mammals(int id, String name, String sound, String Description) {
        super(id, name, "Mammal", sound, Description);
    }
}

class Amphibian extends Animal {
    public Amphibian(int id, String name, String sou, String Des) {
        super(id, name, "Amphibian", sou, Des);
    }
}

class Reptile extends Animal {
    public Reptile(int id, String name, String s, String d) {
        super(id, name, "Reptile", s, d);
    }
}

class Admin {
    private String username;
    private String password;

    public Admin(String PS, String US) {
        this.password = PS;
        this.username = US;
    }

    public void setusername(String us) {
        this.username = us;
    }

    public String getusername() {
        return this.username;
    }

    public void setpassword(String ps) {
        this.password = ps;
    }

    public String getpassword() {
        return this.password;
    }
}

class SpecialDeal {
    private int Attractioncount;
    private int discount;
    private int id;

    public SpecialDeal(int id, int Attractioncount, int discount) {
        this.Attractioncount = Attractioncount;
        this.discount = discount;
        this.id = id;
    }

    public int getAttractioncount() {
        return Attractioncount;
    }

    public int getDiscount() {
        return discount;
    }

    public int getsdid() {
        return this.id;
    }
}

class Discount {
    private int percentage;
    private String DisCode;
    private int Category;

    public Discount(int per, String Dis, int Cat) {
        this.percentage = per;
        this.DisCode = Dis;
        this.Category = Cat;
    }

    public int getCategory() {
        return this.Category;
    }

    public int getper() {
        return this.percentage;
    }

    public String getDiscode() {
        return this.DisCode;
    }

    public void setpercentage(int f) {
        this.percentage = f;
    }

    public void setcode(String ff) {
        this.DisCode = ff;
    }

    public void setcategory(int h) {
        this.Category = h;
    }
}

class Attraction {
    private int id;
    private String name;
    private String description;
    private double price;
    private int ticketsold;
    private int status;

    public Attraction(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = 0;
        this.ticketsold = 0;
        this.status = 2;
    }

    public void setname(String s) {
        this.name = s;
    }

    public void setstatus(int h) {
        this.status = h;
    }

    public int getstatus() {
        return this.status;
    }

    public void setdescription(String des) {
        this.description = des;
    }

    public void setticketsold(int a) {
        this.ticketsold = a;
    }

    public int getId() {
        return id;
    }

    public void setprice(double g) {
        this.price = g;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getticketsold() {
        return ticketsold;
    }
}

interface FeedbackInterface {
    void setFeedback(String s);

    String getfeedback();
}

class Feedback implements FeedbackInterface {
    private String feedbackText;

    public Feedback(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    @Override
    public void setFeedback(String s) {
        feedbackText = s;
    }

    @Override
    public String getfeedback() {
        return this.feedbackText;
    }
}

interface visitor {
    int buyticket(int id, double price, int perc);

    int visitattraction(int id);

    void buymembership(int id, int dpercentage, int minorsin);
}

class Visitor {
    private int membership;
    private String name;
    private int age;
    private long Phonenumber;
    private double balance;
    private String mail;
    private String Password;
    private List<Integer> attractionsID;

    public Visitor(String na, int ag, long pn, double bal, String mai, String ps) {
        this.name = na;
        this.age = ag;
        this.Phonenumber = pn;
        this.balance = bal;
        this.mail = mai;
        this.Password = ps;
        this.attractionsID = new ArrayList<>();
        this.membership = 0;
    }

    public double getbalance() {
        return this.balance;
    }

    public String getmail() {
        return this.mail;
    }

    public String getnam() {
        return this.name;
    }

    public long retphone() {
        return this.Phonenumber;
    }

    public void setmembership(int u) {
        this.membership = u;
    }

    public int getmembership() {
        return this.membership;
    }

    public String getpassword() {
        return this.Password;
    }

    public void setbalance(double z) {
        this.balance = z;
    }

    public int getage() {
        return this.age;
    }

    public int buyticket(int id, double atprice, int discountper) {
        int gh = 0;
        if (this.getmembership() == 1) {
            if (this.getbalance() >= atprice) {
                this.attractionsID.add(id);
                double rembal = this.getbalance() - (atprice - (atprice * ((double) discountper / 100)));
                this.setbalance(rembal);
                System.out.println(
                        "Ticket purchased Successfully and your remaining balance is: " + this.getbalance());
                gh = 1;
            } else {
                System.out.println("Insufficient balance");
            }
        } else if (this.getmembership() != 1 && this.getmembership() != 2) {
            System.out.println("OOPS , you have not purchased any membership of zoo");
        }
        return gh;
    }

    public int visitattraction(int id) {
        int oo = 0;
        if (this.getmembership() == 1) {
            Iterator<Integer> iterator = attractionsID.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                if (i == id) {
                    oo = 1;
                    iterator.remove();
                    break;
                }
            }
        } else if (this.getmembership() == 2) {
            oo = 2;
        }
        return oo;
    }

    public void buymembership(int y, int dper, int cat) {
        if (this.getmembership() != 2 && this.getmembership() != 1) {
            if (y == 1 && this.getbalance() >= 20) {
                if (this.getage() < 18 && cat == 1) {
                    this.membership = 1;
                    double k = this.getbalance() - (20 - (20 * ((double) dper / 100)));
                    this.setbalance(k);
                    System.out.println("Basic membership has been purchased");
                } else if (this.getage() > 60 && cat == 2) {
                    this.membership = 1;
                    double k = this.getbalance() - (20 - (20 * ((double) dper / 100)));
                    this.setbalance(k);
                    System.out.println("Basic membership has been purchased");
                } else {
                    this.membership = 1;
                    double k = this.getbalance() - 20;
                    this.setbalance(k);
                    System.out.println("Basic membership has been purchased");
                }

            } else if (y == 2 && this.getbalance() >= 50) {
                if (this.getage() < 18 && cat == 1) {
                    this.membership = 2;
                    double k = this.getbalance() - (50 - (50 * ((double) dper / 100)));
                    this.setbalance(k);
                    System.out.println("Premium Membership has been purchased");
                } else if (this.getage() > 60 && cat == 2) {
                    this.membership = 2;
                    double k = this.getbalance() - (50 - (50 * ((double) dper / 100)));
                    this.setbalance(k);
                    System.out.println("Premium Membership has been purchased");
                } else {
                    this.membership = 2;
                    double k = this.getbalance() - 50;
                    this.setbalance(k);
                    System.out.println("Premium Membership has been purchased");
                }
            } else {
                System.out.println("Insufficient bal");
            }
        }
    }
}

abstract class Membership {
    private int memberId;
    private String name;
    private String email;

    public Membership(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public abstract int getMembershipType();

    public int get() {
        return this.memberId;
    }

    public String getna() {
        return this.name;
    }

    public String getma() {
        return this.email;
    }
}

class Basic extends Membership {
    public Basic(int memberId, String name, String email) {
        super(memberId, name, email);
    }

    @Override
    public int getMembershipType() {
        return 1;
    }
}

class Premium extends Membership {
    public Premium(int memberId, String name, String email) {
        super(memberId, name, email);
    }

    @Override
    public int getMembershipType() {
        return 2;
    }
}

class ZOO {
    static int AttractionID = 0;
    List<Admin> AD;
    List<Visitor> VS;
    List<Attraction> AT;
    List<Feedback> FB;
    List<Discount> DIS;
    List<SpecialDeal> SD;
    List<Amphibian> AM;
    List<Mammals> MA;
    List<Reptile> RL;
    List<Animal> AA;
    static int mamid = 0;
    static int ampid = 0;
    static int repid = 0;
    private int sdid = 0;

    public ZOO() {
        this.AD = new ArrayList<>();
        this.VS = new ArrayList<>();
        this.AT = new ArrayList<>();
        this.FB = new ArrayList<>();
        this.DIS = new ArrayList<>();
        this.SD = new ArrayList<>();
        this.AM = new ArrayList<>();
        this.MA = new ArrayList<>();
        this.RL = new ArrayList<>();
        this.AA = new ArrayList<>();
        this.MS = new ArrayList<>();
    }

    public int addanimal(String name, String type, String s, String d) {
        int y = 0;
        if (type.equals("Mammal")) {
            mamid++;
            Mammals m = new Mammals(mamid, name, s, d);
            MA.add(m);
            AA.add(m);
            y = 1;
        } else if (type.equals("Amphibian")) {
            mamid++;
            Amphibian m = new Amphibian(mamid, name, s, d);
            AM.add(m);
            AA.add(m);
            y = 1;
        } else if (type.equals("Reptile")) {
            mamid++;
            Reptile m = new Reptile(mamid, name, s, d);
            RL.add(m);
            AA.add(m);
            y = 1;
        } else {
            System.out.println("Animal can only be type of Mammal , Amphibian or Reptile");
        }
        return y;
    }

    public void registeradmin(String pass, String user) {
        Admin a = new Admin(pass, user);
        AD.add(a);
    }

    public int checkadmin(String p, String u) {
        int pre = 0;
        for (Admin A : AD) {
            if (A.getusername().equals(u) && A.getpassword().equals(p)) {
                pre = 1;
            }
        }
        return pre;
    }

    List<Membership> MS;

    public void Addattraction(String name, String Des) {
        AttractionID++;
        Attraction att = new Attraction(AttractionID, name, Des);
        AT.add(att);
        System.out.println("Attraction Added Successfully!!");
    }

    public void removeattraction(int a) {
        for (Attraction aaa : AT) {
            if (aaa.getId() == a) {
                AT.remove(aaa);
                System.out.println("Attraction Removed Successfully!!");
                break;
            }
        }
    }

    public int modifyattraction(int m) {
        int hh = 0;
        for (Attraction a : AT) {
            if (a.getId() == m) {
                hh = 1;
            }
        }
        return hh;
    }

    public void renameattraction(int j, String rena) {
        for (Attraction a : AT) {
            if (a.getId() == j) {
                a.setname(rena);
            }
        }
    }

    public void renamedescription(int j, String newdes) {
        for (Attraction as : AT) {
            if (as.getId() == j) {
                as.setdescription(newdes);
            }
        }
    }

    public void registervisitor(String n, int a, long p, double b, String e, String ps) {
        Visitor vi = new Visitor(n, a, p, b, e, ps);
        VS.add(vi);
        System.out.println("Registration is successful.");
    }

    public int visitorLogin(String email, String pas) {
        int ch = 0;
        for (Visitor V : VS) {
            if (V.getmail().equals(email) && V.getpassword().equals(pas)) {
                ch = 1;
            } else {
                ch = 0;
            }
        }
        return ch;
    }

    public int getsizeofAT() {
        return AT.size();
    }

    public void viewattractions() {
        for (Attraction AA : AT) {
            System.out.println("Attraction ID: " + AA.getId());
            System.out.println("Attraction Name: " + AA.getName());
            System.out.println("Attraction Description: " + AA.getDescription());
            System.out.println("Attraction Visitors: " + AA.getticketsold());
        }
    }

    public void addDiscount(int category, String Code, int per) {
        Discount d = new Discount(per, Code, category);
        DIS.add(d);
        System.out.println("Discount added successfully");
    }

    public void showdiscounts() {
        for (Discount d : DIS) {
            System.out.println("Discount code: " + d.getDiscode());
            System.out.println("Discount percentage: " + d.getper());
        }
    }

    public int isdispresent(String h) {
        int i = 0;
        for (Discount f : DIS) {
            if (f.getDiscode().equals(h)) {
                i = 1;
                break;
            }
        }
        return i;
    }

    public void getdescription(int f) {
        int o = 0;
        Attraction a = null;
        for (Attraction p : AT) {
            if (p.getId() == f) {
                a = p;
                o = 1;
                break;
            }
        }
        if (o == 1) {
            System.out.println(a.getDescription());
        } else {
            System.out.println("Attraction with this ID is not present");
        }
    }

    public int removediscount(String s) {
        int uu = 0;
        for (Discount dd : DIS) {
            if (dd.getDiscode().equals(s)) {
                DIS.remove(dd);
                uu = 1;
                break;
            }
        }
        return uu;
    }

    public void changediscode(String prevcode, String newcode) {
        for (Discount s : DIS) {
            if (s.getDiscode().equals(prevcode)) {
                s.setcode(newcode);
            }
        }
    }

    public void changeper(String s, int h) {
        for (Discount f : DIS) {
            if (f.getDiscode().equals(s)) {
                f.setpercentage(h);
                System.out.println("Percentage changed Successfully!!");
                break;
            }
        }
    }

    public void viewfeedback() {
        if (FB.size() == 0) {
            System.out.println("NO FEEDBACK PRESENT");
        } else {
            for (Feedback f : FB) {
                System.out.println("-" + f.getfeedback());
            }
        }
    }

    public void Incticketsold(int id) {
        for (Attraction a : AT) {
            if (a.getId() == id) {
                int tc = a.getticketsold() + 1;
                a.setticketsold(tc);
            }
        }
    }

    public void setopenclosed(int id, int sta) {
        Attraction h = null;
        int iy = 0;
        for (Attraction aa : AT) {
            if (aa.getId() == id) {
                iy = 1;
                h = aa;
                if (sta == 1) {
                    aa.setstatus(1);
                    System.out.println(h.getName() + " Has been opened");
                } else if (sta == 2) {
                    aa.setstatus(2);
                    System.out.println(h.getName() + " Has been closed");
                } else {
                    System.out.println("Invalid status");
                }
                break;
            }
        }
        if (iy == 0) {
            System.out.println("Attraction with this ID in not present");
        }
    }

    public void addspecialdeal(int min, int pp) {
        sdid++;
        SpecialDeal s = new SpecialDeal(sdid, min, pp);
        SD.add(s);
    }

    public void showspecialdeals() {
        if (SD.size() == 0) {
            System.out.println("No special Deals are present!!");
        } else {
            for (SpecialDeal s : SD) {
                System.out.println(s.getsdid() + ". " + "Buy " + s.getAttractioncount() + " tickets and get "
                        + s.getDiscount() + "% off");
            }
        }
    }

    public double returnattractionprice(int id) {
        double gg = 0;
        for (Attraction ss : AT) {
            if (ss.getId() == id) {
                gg = ss.getPrice();
            }

        }
        return gg;
    }

    public void viewattname() {
        for (Attraction at : AT) {
            System.out.println("Attraction ID: " + at.getId());
            System.out.println("Attraction Name: " + at.getName());
            // System.out.println("Attraction Description: " + at.getDescription());
            System.out.println("Attraction Price: " + at.getPrice());
        }
    }

    public void setprice(int id, double price) {
        int yyy = 0;
        for (Attraction p : AT) {
            if (p.getId() == id) {
                p.setprice(price);
                yyy = 1;
                break;
            }
        }
        if (yyy == 1) {
            System.out.println("Price set successfully");
        } else {
            System.out.println("Attraction with this ID is not present");
        }
    }

    public int getattractionstatus(int idd) {
        int h = 0;
        for (Attraction ii : AT) {
            if (ii.getId() == idd) {
                h = ii.getstatus();
                break;
            }
        }
        return h;
    }

    public void getmostpopular() {
        if (AT.size() == 0) {
            System.out.println("No Attractions are there!!");
        } else {
            int mc = 0;
            Attraction maxcount = null;
            for (Attraction attra : AT) {
                if (attra.getticketsold() > mc) {
                    maxcount = attra;
                    mc = attra.getticketsold();
                }
            }
            System.out.println("Most visited Attraction: " + maxcount.getName());
        }

    }

    public int retsdper(int y) {
        int u = 0;
        for (SpecialDeal sd : SD) {
            if (sd.getAttractioncount() == y) {
                u = sd.getDiscount();
                break;
            }
        }
        return u;
    }

    public int retper(String code) {
        int yyyy = 0;
        for (Discount d : DIS) {
            if (d.getDiscode().equals(code)) {
                yyyy = d.getper();
                break;
            } else {
                yyyy = 0;
            }
        }
        return yyyy;
    }

    public void Addfeedback(String s) {
        Feedback f = new Feedback(s);
        FB.add(f);
    }

    public Visitor returnvVisitor(String email, String pass) {
        Visitor v = null;
        for (Visitor vv : VS) {
            if (vv.getmail().equals(email) && vv.getpassword().equals(pass)) {
                v = vv;
                break;
            }
        }
        return v;
    }

    public void AD(Discount f) {
        DIS.add(f);
    }

    public Discount reDiscount(String code) {
        Discount f = null;
        for (Discount dd : DIS) {
            if (dd.getDiscode().equals(code)) {
                f = dd;
            }
        }
        return f;
    }

    public void removeani(int id) {
        int cc = 0;
        for (Animal ee : AA) {
            if (ee.getId() == id && ee.getType().equals("Mammal") && MA.size() > 2) {
                AA.remove(ee);
                MA.remove(ee);
                cc = 1;
                System.out.println("Animal Removed");
                break;
            } else if (ee.getId() == id && ee.getType().equals("Mammal") && MA.size() <= 2) {
                System.out.println("You Cannot removed because atleast 2 should be present");
            } else if (ee.getId() == id && ee.getType().equals("Amphibian") && AM.size() > 2) {
                AA.remove(ee);
                AM.remove(ee);
                cc = 1;
                System.out.println("Animal Removed");
                break;
            } else if (ee.getId() == id && ee.getType().equals("Amphibian") && AM.size() <= 2) {
                System.out.println("You Cannot removed because atleast 2 should be present");
                cc = 1;
            } else if (ee.getId() == id && ee.getType().equals("Reptile") && RL.size() > 2) {
                AA.remove(ee);
                RL.remove(ee);
                System.out.println("Animal Removed");
                break;
            } else if (ee.getId() == id && ee.getType().equals("Amphibian") && AM.size() <= 2) {
                System.out.println("You Cannot removed because atleast 2 should be present");
                cc = 1;
            } else if (ee.getId() == id && ee.getType().equals("Reptile") && RL.size() <= 2) {
                System.out.println("You Cannot removed because atleast 2 should be present");
                cc = 1;
            }
        }
        if (cc == 0) {
            System.out.println("Invalid Input");
        }
    }

    public void changeanimalname(int id, String nn) {
        for (Animal rr : AA) {
            if (rr.getId() == id) {
                rr.setName(nn);
                System.out.println("Name changed successfully!!");
                break;
            }
        }
    }

    public void changeanimaldesc(int id, String nn) {
        for (Animal rr : AA) {
            if (rr.getId() == id) {
                rr.setDescription(nn);
                System.out.println("Description changed successfully!!");
                break;
            }
        }
    }

    public void changeanimalsound(int id, String nn) {
        for (Animal rr : AA) {
            if (rr.getId() == id) {
                rr.setSound(nn);
                System.out.println("Sound changed successfully!!");
                break;
            }
        }
    }

    public void showani() {
        for (Animal e : AA) {
            System.out.println(e.getId() + ". " + e.getName());
            System.out.println("Type: " + e.getType());
        }
    }

    public int anipre(int h) {
        int p = 0;
        for (Animal eee : AA) {
            if (eee.getId() == h) {
                p = 1;
                break;
            }
        }
        return p;
    }

    public int Getint(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input, Please Try Again!!");
            }
        }
    }

    public void removespdecialdeal(int id) {
        int checker = 0;
        for (SpecialDeal sd : SD) {
            if (sd.getsdid() == id) {
                SD.remove(sd);
                checker = 1;
                System.out.println("Special Deal Removed Successfully!!");
                break;
            }
        }
        if (checker == 0) {
            System.out.println("Invalid");
        }
    }

    public int attractionpresent(int h) {
        int ji = 0;
        for (Attraction a : AT) {
            if (a.getId() == h) {
                ji = 1;
            }
        }
        return ji;
    }

    public int readorfeed(int rof, int id) {
        int uio = 0;
        for (Animal rr : AA) {
            if (rr.getId() == id) {
                if (rof == 1) {
                    uio = 1;
                    System.out.println(rr.getDescription());
                    break;
                } else if (rof == 2) {
                    uio = 2;
                    System.out.println(rr.getSound());
                    break;
                }
            }
        }
        return uio;
    }
}

public class Main {
    public static void main(String[] args) {
        int stats = 0;
        double revenue = 0;
        ZOO zootopia = new ZOO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ZOOtopia!");
        zootopia.registeradmin("Z123", "Zoey01");
        zootopia.registeradmin("J123", "Jack02");
        zootopia.addanimal("Lion", "Mammal", "Roar", "The king of zoo");
        zootopia.addanimal("Monkey", "Mammal", "chatter", "They are the craziest");
        zootopia.addanimal("Fire Salamander", "Amphibian", "Tur tur",
                "It is black with yellow spots or stripes to a varying degree");
        zootopia.addanimal("Snake", "Reptile", "hiss", "Most Dangerous species and varies.");
        zootopia.addanimal("Toads", "Amphibian", "tirr", "Eats all the insect");
        zootopia.addanimal("Crocodile", "Reptile", "Chirp",
                "These reptiles are large, and have thick scales, long snouts, and many sharp teeth.");
        zootopia.addspecialdeal(2, 15);
        zootopia.addspecialdeal(3, 30);
        while (true) {
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as Visitor");
            System.out.println("3. View Special Deals");
            System.out.print("Enter your choice: ");
            String a = sc.next();
            if (a.equals("1")) {
                sc.nextLine();
                System.out.print("Enter Admin Username: ");
                String USS = sc.nextLine();
                System.out.print("Enter Admin Password: ");
                String PSS = sc.nextLine();
                int Admincheck = zootopia.checkadmin(PSS, USS);
                if (Admincheck == 1) {
                    System.out.println("Logged in as Admin");
                    while (true) {
                        System.out.println("\n");
                        System.out.println("Admin Menu:");
                        System.out.println("1. Manage Attractions");
                        System.out.println("2. Manage Animals");
                        System.out.println("3. Schedule Events");
                        System.out.println("4. Set Discounts");
                        System.out.println("5. Set Special Deal");
                        System.out.println("6. View Visitor Stats");
                        System.out.println("7. View Feedback");
                        System.out.println("8. Exit");
                        System.out.print("Enter your choice: ");
                        String b = sc.next();
                        if (b.equals("1")) {
                            while (true) {
                                System.out.println("1. Add Attraction\r\n" + //
                                        "2. View Attractions\r\n" + //
                                        "3. Modify Attractions\r\n" + //
                                        "4. Remove Attraction\r\n" + //
                                        "5. Exit");
                                System.out.print("Enter your choice: ");
                                String c = sc.next();
                                if (c.equals("1")) {
                                    System.out.print("Enter Name of attraction: ");
                                    sc.nextLine();
                                    String namee = sc.nextLine();
                                    System.out.print("Enter Description of attraction: ");
                                    String DES = sc.nextLine();
                                    zootopia.Addattraction(namee, DES);
                                } else if (c.equals("5")) {
                                    break;
                                } else if (c.equals("2")) {
                                    zootopia.viewattractions();
                                } else if (c.equals("4")) {
                                    if (zootopia.getsizeofAT() == 0) {
                                        System.out.print("No Attractions are present!!");
                                        break;
                                    } else {
                                        zootopia.viewattname();
                                        sc.nextLine();
                                        int remid = zootopia.Getint(sc, "Enter ID of attraction to be removed: ");
                                        zootopia.removeattraction(remid);
                                        break;
                                    }

                                } else if (c.equals("3")) {
                                    zootopia.viewattname();
                                    sc.nextLine();
                                    int ma = zootopia.Getint(sc, "Enter Id of attraction you want to modify: ");
                                    int atpr = zootopia.modifyattraction(ma);
                                    if (atpr == 1) {
                                        while (true) {
                                            System.out.println("1. Rename ");
                                            System.out.println("2. Change Description ");
                                            System.out.println("3. Exit");
                                            System.out.print("Enter your choice: ");
                                            String RC = sc.next();
                                            if (RC.equals("1")) {
                                                sc.nextLine();
                                                System.out.println("Enter the new name for attraction: ");
                                                String rename = sc.nextLine();
                                                zootopia.renameattraction(ma, rename);
                                                System.out.println("Renamed Successfully");
                                            } else if (RC.equals("2")) {
                                                System.out.println("Enter the new Description for attraction: ");
                                                sc.nextLine();
                                                String Nds = sc.nextLine();
                                                zootopia.renamedescription(ma, Nds);
                                                System.out.println("Description Modified Successfully");

                                            } else if (RC.equals("3")) {
                                                break;
                                            } else {
                                                System.out.println("Invalid Input");
                                            }
                                        }
                                    } else {
                                        System.out.println("Attraction with this ID is not present");
                                    }
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            }
                        } else if (b.equals("2")) {
                            while (true) {
                                System.out.println("Manage Animals:");
                                System.out.println("1. Add Animal");
                                System.out.println("2. Update Animal Details");
                                System.out.println("3. Remove Animal");
                                System.out.println("4. Exit");
                                System.out.print("Enter your choice: ");
                                String ani = sc.next();
                                if (ani.equals("4")) {
                                    break;
                                } else if (ani.equals("1")) {
                                    sc.nextLine();
                                    System.out.print("Enter Animal Name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter Animal Type: ");
                                    String type = sc.nextLine();
                                    System.out.print("Enter Animal Sound: ");
                                    String sound = sc.nextLine();
                                    System.out.print("Enter Animal Description: ");
                                    String description = sc.nextLine();
                                    int uu = zootopia.addanimal(name, type, sound, description);
                                    if (uu == 1) {
                                        System.out.println("Animal Added Successfully");
                                    }
                                } else if (ani.equals("3")) {
                                    zootopia.showani();
                                    sc.nextLine();
                                    int y = zootopia.Getint(sc, "Enter your choice: ");
                                    zootopia.removeani(y);
                                } else if (ani.equals("2")) {
                                    zootopia.showani();
                                    sc.nextLine();
                                    int mod = zootopia.Getint(sc, "Select to modify: ");
                                    int check = zootopia.anipre(mod);
                                    if (check == 0) {
                                        System.out.println("Invalid Input");
                                    } else {
                                        System.out.println("What you want to update: ");
                                        System.out.println("1. Name");
                                        System.out.println("2. Sound");
                                        System.out.println("3. Description");
                                        String h = sc.next();
                                        if (h.equals("1")) {
                                            System.out.print("Enter new name: ");
                                            String newname = sc.next();
                                            zootopia.changeanimalname(mod, newname);
                                        } else if (h.equals("2")) {
                                            System.out.print("Enter new Sound: ");
                                            String newsound = sc.next();
                                            zootopia.changeanimalsound(mod, newsound);
                                        } else if (h.equals("3")) {
                                            System.out.print("Enter new Description: ");
                                            String newdesc = sc.next();
                                            zootopia.changeanimaldesc(mod, newdesc);
                                        } else {
                                            System.out.println("Invalid input");
                                        }
                                    }
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            }
                        } else if (b.equals("6")) {
                            System.out.println("Total Visitors: " + stats);
                            System.out.println("Total Revenue Generated: Rs." + revenue);
                            zootopia.getmostpopular();
                        } else if (b.equals("3")) {
                            zootopia.viewattname();
                            sc.nextLine();
                            int hhh = zootopia.Getint(sc, "Enter your choice: ");
                            int isatrpre = zootopia.attractionpresent(hhh);
                            if (isatrpre == 1) {
                                System.out.println("1. Make it open");
                                System.out.println("2. Make it close");
                                System.out.println("3. Set price");
                                int se = zootopia.Getint(sc, "Enter your choice: ");
                                if (se == 3) {
                                    System.out.print("Enter the price: ");
                                    double prr = sc.nextDouble();
                                    zootopia.setprice(hhh, prr);
                                } else if (se == 2) {
                                    zootopia.setopenclosed(hhh, se);
                                } else if (se == 1) {
                                    zootopia.setopenclosed(hhh, se);
                                }
                            } else {
                                System.out.println("Attraction with this Id is not present.");
                            }
                        } else if (b.equals("8")) {
                            System.out.println("Logged out");
                            break;
                        } else if (b.equals("7")) {
                            zootopia.viewfeedback();
                        } else if (b.equals("4")) {
                            while (true) {
                                System.out.println("Set Discounts:");
                                System.out.println("1. Add Discount");
                                System.out.println("2. Modify Discount");
                                System.out.println("3. Remove Discount");
                                System.out.println("4. Exit");
                                System.out.print("Enter your choice: ");
                                String Ds = sc.next();
                                if (Ds.equals("4")) {
                                    break;
                                } else if (Ds.equals("1")) {
                                    System.out.println("Enter disount Category: ");
                                    System.out.println("1. minor");
                                    System.out.println("2. senior");
                                    sc.nextLine();
                                    int cat = zootopia.Getint(sc, "Enter your choice: ");
                                    // sc.nextLine();
                                    System.out.print("Enter Disount Code: ");
                                    String dc = sc.nextLine();
                                    // sc.nextLine();
                                    int pp = zootopia.Getint(sc, "Enter percentage(15 for 15%): ");
                                    zootopia.addDiscount(cat, dc, pp);
                                } else if (Ds.equals("3")) {
                                    zootopia.showdiscounts();
                                    System.out.println("Enter Discount code to remove that discount: ");
                                    sc.nextLine();
                                    String remdis = sc.nextLine();
                                    int q = zootopia.removediscount(remdis);
                                    if (q == 1) {
                                        System.out.println("Discount Removed successfully");
                                    } else {
                                        System.out.println("Discount with this code is not present");
                                    }
                                } else if (Ds.equals("2")) {
                                    zootopia.showdiscounts();
                                    sc.nextLine();
                                    System.out
                                            .println("Enter the Discount code for the discount you wants to modify: ");
                                    String ddd = sc.nextLine();
                                    int o = zootopia.isdispresent(ddd);
                                    if (o == 1) {
                                        while (true) {
                                            System.out.println("1. change Discount code");
                                            System.out.println("2. change Discount percentage");
                                            System.out.println("3. Exit");
                                            System.out.print("Enter your choice: ");
                                            String j = sc.next();
                                            if (j.equals("3")) {
                                                break;
                                            } else if (j.equals("1")) {
                                                System.out.print("Enter new code: ");
                                                sc.nextLine();
                                                String newcode = sc.nextLine();
                                                zootopia.changediscode(ddd, newcode);
                                                System.out.println("Discount Code changes successfully");
                                            } else if (j.equals("2")) {
                                                sc.nextLine();
                                                int newper = zootopia.Getint(sc, "Enter new percentage for discount: ");
                                                zootopia.changeper(ddd, newper);
                                            } else {
                                                System.out.println("Invalid Input");
                                            }
                                        }
                                    } else {
                                        System.out.println("Discount for this code is not present");
                                    }
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            }
                        } else if (b.equals("5")) {
                            System.out.println("Set Special Deals: ");
                            System.out.println("1. Add special Deal");
                            System.out.println("2. Remove special Deal");
                            String yoyo = sc.next();
                            if (yoyo.equals("1")) {
                                sc.nextLine();
                                int minattr = zootopia.Getint(sc, "Enter the min number of attraction: ");
                                int pers = zootopia.Getint(sc, "Enter percentage for discount(15 for 15%): ");
                                zootopia.addspecialdeal(minattr, pers);
                                System.out.println("Special Deal Added successfully");
                            } else if (yoyo.equals("2")) {
                                zootopia.showspecialdeals();
                                sc.nextLine();
                                int remsd = zootopia.Getint(sc, "Select to Remove: ");
                                zootopia.removespdecialdeal(remsd);
                            } else {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid Admin Details");
                }
            } else if (a.equals("2")) {
                while (true) {
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    String RL = sc.next();
                    if (RL.equals("1")) {
                        sc.nextLine();
                        System.out.print("Enter Visitor Name: ");
                        String nam = sc.nextLine();
                        int ag = zootopia.Getint(sc, "Enter Age: ");
                        if (ag <= 0) {
                            System.out.println("Invalid Age");
                            break;
                        }
                        System.out.print("Enter Phone number: ");
                        long pnn = sc.nextLong();
                        sc.nextLine();
                        double bal = zootopia.Getint(sc, "Enter Visitor Balance: ");
                        if (bal < 0) {
                            System.out.println("Balance cannot be negative");
                            break;
                        }
                        System.out.print("Enter Visitor's Mail: ");
                        // sc.nextLine();
                        String ma = sc.nextLine();
                        System.out.print("Enter Visitor's password: ");
                        String ps = sc.nextLine();
                        zootopia.registervisitor(nam, ag, pnn, bal, ma, ps);
                        System.out.println();
                        stats++;
                    } else if (RL.equals("2")) {
                        System.out.print("Enter Visitor's Email: ");
                        sc.nextLine();
                        String emm = sc.nextLine();
                        System.out.print("Enter Visitor password: ");
                        String pass = sc.nextLine();
                        int ispr = zootopia.visitorLogin(emm, pass);
                        if (ispr == 1) {
                            System.out.println("\n");
                            System.out.println("Login Successful");
                            System.out.println("\n");
                            while (true) {
                                System.out.println("Visitor Menu:");
                                System.out.println("1. Explore the Zoo");
                                System.out.println("2. Buy Membership");
                                System.out.println("3. Buy Tickets");
                                System.out.println("4. View Discounts");
                                System.out.println("5. View Special Deals");
                                System.out.println("6. Visit Animals");
                                System.out.println("7. Visit Attractions");
                                System.out.println("8. Leave Feedback");
                                System.out.println("9. Log Out");
                                System.out.print("Enter your choice: ");
                                String Ls = sc.next();
                                if (Ls.equals("9")) {
                                    System.out.println("Logged out");
                                    break;
                                } else if (Ls.equals("4")) {
                                    zootopia.showdiscounts();
                                } else if (Ls.equals("1")) {
                                    while (true) {
                                        System.out.println("Explore the Zoo:");
                                        System.out.println("1. View Attractions");
                                        System.out.println("2. View Animals");
                                        System.out.println("3. Exit");
                                        String EZ = sc.next();
                                        if (EZ.equals("3")) {
                                            break;
                                        } else if (EZ.equals("1")) {
                                            zootopia.viewattname();
                                            sc.nextLine();
                                            int s = zootopia.Getint(sc, "Enter your choice: ");
                                            zootopia.getdescription(s);
                                        } else if (EZ.equals("2")) {
                                            zootopia.showani();
                                        } else {
                                            System.out.println("Invalid Input");
                                        }
                                    }
                                } else if (Ls.equals("6")) {
                                    Visitor vvv = zootopia.returnvVisitor(emm, pass);
                                    if (vvv.getmembership() == 1 || vvv.getmembership() == 2) {
                                        zootopia.showani();
                                        sc.nextLine();
                                        int io = zootopia.Getint(sc, "Select animal to visit: ");
                                        int yy = zootopia.anipre(io);
                                        if (yy == 1) {
                                            System.out.println("1. Read");
                                            System.out.println("2. Feed");
                                            int rof = zootopia.Getint(sc, "Enter your choice: ");
                                            int pl = zootopia.readorfeed(rof, io);
                                            if (pl == 0) {
                                                System.out.println("Invalid");
                                            }
                                        } else {
                                            System.out.println("Invalid");
                                        }
                                    } else {
                                        System.out.println("Firstly Purchase Membership");
                                    }

                                } else if (Ls.equals("2")) {
                                    Visitor v2 = zootopia.returnvVisitor(emm, pass);
                                    int memst = v2.getmembership();
                                    if (memst == 1 || memst == 2) {
                                        System.out.println("You have already purchased the membership");
                                    } else {
                                        System.out.println("Buy Membership: ");
                                        System.out.println("1. Basic Membership(Rs. 20)");
                                        System.out.println("2. Premium Membership(Rs. 50)");
                                        sc.nextLine();
                                        int oi = zootopia.Getint(sc, "Enter your choice: ");
                                        zootopia.showdiscounts();
                                        System.out.println("Enter Discount code (if not enter none): ");
                                        String s = sc.next();
                                        if (zootopia.isdispresent(s) == 1) {
                                            Discount jj = zootopia.reDiscount(s);
                                            int dper = zootopia.retper(s);
                                            v2.buymembership(oi, dper, jj.getCategory());
                                            System.out.println(v2.getbalance());
                                            if (oi == 1 && jj.getCategory() == 1 && v2.getage() < 18) {
                                                revenue = revenue + (20 - (20 * dper / 100));
                                            } else if (oi == 1 && jj.getCategory() == 1 && v2.getage() > 18) {
                                                revenue = revenue + 20;
                                            } else if (oi == 1 && jj.getCategory() == 2 && v2.getage() > 60) {
                                                revenue = revenue + (20 - (20 * (dper / 100)));
                                            } else if (oi == 1 && jj.getCategory() == 2 && v2.getage() < 60) {
                                                revenue = revenue + 20;
                                            } else if (oi == 2 && jj.getCategory() == 1 && v2.getage() < 18) {
                                                revenue = revenue + (50 - (50 * dper / 100));
                                            } else if (oi == 2 && jj.getCategory() == 1 && v2.getage() > 18) {
                                                revenue = revenue + 50;
                                            } else if (oi == 2 && jj.getCategory() == 2 && v2.getage() > 60) {
                                                revenue = revenue + (50 - (50 * (dper / 100)));
                                            } else if (oi == 2 && jj.getCategory() == 2 && v2.getage() < 60) {
                                                revenue = revenue + 50;
                                            } else if (jj.getCategory() != 1 && jj.getCategory() != 2) {
                                                if (oi == 1) {
                                                    revenue = revenue + 20;
                                                } else if (oi == 2) {
                                                    revenue = revenue + 50;
                                                }
                                            }
                                        } else {
                                            int dper = zootopia.retper(s);
                                            v2.buymembership(oi, dper, 0);
                                            if (oi == 1) {
                                                revenue += 20;
                                            } else if (oi == 2) {
                                                revenue += 50;
                                            }
                                        }
                                    }
                                } else if (Ls.equals("5")) {
                                    zootopia.showspecialdeals();
                                } else if (Ls.equals("3")) {
                                    Visitor v22 = zootopia.returnvVisitor(emm, pass);
                                    if (v22.getmembership() == 2) {
                                        System.out.println("You have premium Membership!!");
                                    } else {
                                        zootopia.showspecialdeals();
                                        System.out.println("Buy Tickets: ");
                                        sc.nextLine();
                                        int ticketnum = zootopia.Getint(sc, "How many tickets you have to buy: ");
                                        int yp = zootopia.retsdper(ticketnum);
                                        System.out.println(yp);
                                        for (int i = 0; i < ticketnum; i++) {
                                            System.out.println("Select an attraction to buy a ticket: ");
                                            zootopia.viewattname();
                                            int sa = sc.nextInt();
                                            Visitor v = zootopia.returnvVisitor(emm, pass);
                                            double atrprice = zootopia.returnattractionprice(sa);
                                            int op = zootopia.getattractionstatus(sa);
                                            if (op == 1) {
                                                int z = v.buyticket(sa, atrprice, yp);
                                                if (z == 1) {
                                                    zootopia.Incticketsold(sa);
                                                    revenue = revenue + (atrprice - (atrprice * (yp / 100)));
                                                }
                                            } else if (op == 2) {
                                                System.out.println("Currently this Attraction is Closed");
                                            }
                                        }
                                    }

                                } else if (Ls.equals("7")) {
                                    // System.out.println("Select an Attraction to visit: ");
                                    zootopia.viewattname();
                                    sc.nextLine();
                                    int vat = zootopia.Getint(sc, "Select an Attraction to visit: ");
                                    Visitor v1 = zootopia.returnvVisitor(emm, pass);
                                    int w = v1.visitattraction(vat);
                                    if (w == 1) {
                                        System.out.print("Attraction Visited,Hope you enjoyed it");
                                        System.out.println("\n");
                                    } else if (w == 0) {
                                        System.out.println(
                                                "You have not purchase ticket for this Attraction. Basic Members have to purchase tickets");
                                    } else if (w == 2) {
                                        zootopia.Incticketsold(vat);
                                        System.out.println("Attraction visited,Hope you enjoyed it");
                                    }
                                } else if (Ls.equals("8")) {
                                    System.out.println("Enter feedback you wants to give: ");
                                    sc.nextLine();
                                    String feed = sc.nextLine();
                                    zootopia.Addfeedback(feed);
                                    System.out.println("Thankyou for your Valuable Feedback!!");
                                } else {
                                    System.out.println("Invalid Input");
                                }
                            }
                        } else {
                            System.out.println("Visitor Not present");
                        }

                    } else if (RL.equals("3")) {
                        break;
                    } else {
                        System.out.println("Invalid.");
                    }
                }
            } else if (a.equals("3")) {
                zootopia.showspecialdeals();
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
