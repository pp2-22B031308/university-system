package enums;

public enum OrganizationName {
 OSIT, BCL, CRYSTALS, MONTAIN_KINGS;
  public static OrganizationName convertOrganizationName(int name) {
    switch(name) {
    case 1:
     return OrganizationName.OSIT;
    case 2:
     return OrganizationName.BCL;
    case 3:
     return OrganizationName.CRYSTALS;
    case 4:
     return OrganizationName.MONTAIN_KINGS;
    }
    return null;
   }
}
