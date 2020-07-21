package monitor_model;

public interface Method {
	public boolean tryEnter(ThreadClass auto);
	public void entra(ThreadClass auto);
	public boolean tryExit(ThreadClass auto);
	public void esci(ThreadClass auto);
}
