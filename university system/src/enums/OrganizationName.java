package enums;

public enum OrganizationName {
 OSIT, BCL, CRYSTALS, FACES;
  public static OrganizationName convertOrganizationName(int name) {
    switch(name) {
    case 1:
     return OrganizationName.OSIT;
    case 2:
     return OrganizationName.BCL;
    case 3:
     return OrganizationName.CRYSTALS;
    case 4:
     return OrganizationName.FACES;
    }
    return null;
   }
}
