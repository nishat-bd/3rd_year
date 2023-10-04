load('plain'); %here plain is the file. we've to load .. then work on it.
s=plain;
length=512;
segment=s(8001:8000+length);
seg_dft=abs((fft(segment,length).^2));
seg_idft=real((ifft(seg_dft)));
for i=1:length
    hamming_window(i) = 0.54-0.46*cos(2*pi*(i-1)/(length-1));
end 
segment_w=segment*hamming_window;
subplot(3,2,1)
plot(s);
title('Voice signal');
xlabel('Time');
ylabel('Amplitude');
 
subplot(3,2,2)
plot(segment);
title('Segment signal');
xlabel('Time');
ylabel('Amplitude');
subplot(3,2,3)
plot(segment_w);
title('Segment_w signal');
xlabel('Time');
ylabel('Amplitude');
subplot(3,2,4)
plot(seg_dft);
title('DFT of Segment signal');
xlabel('Time');
ylabel('Amplitude');
subplot(3,2,5)
plot(seg_idft);
title('IDFT of Segment signal');
xlabel('Time');
ylabel('Amplitude');

