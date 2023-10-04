wc=.5*pi; 
N=25; 
w=0:0.1:pi; 
b=fir1(N,wc/pi,blackman(N+1)); 
h=freqz(b,1,w); 
subplot(3,2,1) 
plot(w/pi,abs(h)) 
grid;
xlabel('normalised frequency'); 
ylabel('magnitude in dB') 
title('FIR LPF USING BLACKMAN WINDOW') 
b=fir1(N,wc/pi,hamming(N+1)); 
h=freqz(b,1,w);
subplot(3,2,2) 
plot(w/pi,abs(h)); 
grid; 
xlabel('normalised frequency'); 
ylabel('magnitude in dB') 
title('FIR LPF USING HAMMING WINDOW') 
b=fir1(N,wc/pi,hanning(N+1)); 
h=freqz(b,1,w); 
subplot(3,2,3) 
plot(w/pi,abs(h)); 
grid; 
xlabel('normalised frequency');
ylabel('magnitude in dB') 
title('FIR LPF USING HANNING WINDOW') 
b=fir1(N,wc/pi,kaiser(N+1,3.5)); 
h=freqz(b,1,w); 
subplot(3,2,4) 
plot(w/pi,abs(h)); 
grid; 
xlabel('normalised frequency'); 
ylabel('magnitude in dB') 
title('FIR LPF USING KAISER WINDOW');


