package com.coffeeshop.example.util;


public enum StartMode {
	
	DEVELOPMENT("dev"), PRODUCTION("prod");
	
	private String mode;
	
	private StartMode(String mode){
		this.mode = mode;
	}
	
	public static StartMode resolve() {
		
		String startMode = System.getProperty("start-mode");
		
		return startMode != null ? resolve(startMode) : PRODUCTION;
	}

	private static StartMode resolve(String startMode) {
		for (StartMode dat : values()) {
			if (dat.mode.equalsIgnoreCase(startMode)) {
				return dat;
			}
		}

		throw new RuntimeException("Undefined Start Mode. Value:" + startMode);
	}

	public static boolean isDevelopment() {
		StartMode startMode = resolve();
		return DEVELOPMENT.equals(startMode);
	}

    public static boolean isProduction() {
        StartMode startMode = resolve();
        return PRODUCTION.equals(startMode);
    }

}
